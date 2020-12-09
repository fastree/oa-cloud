package com.fastree.oa.service.system.controller;

import cn.hutool.core.util.IdUtil;
import com.fastree.oa.common.auth.code.CodeEnum;
import com.fastree.oa.common.auth.code.CodeProperties;
import com.fastree.oa.common.auth.code.CodeProvider;
import com.fastree.oa.common.auth.jwt.JwtProvider;
import com.fastree.oa.common.base.domain.Result;
import com.fastree.oa.common.redis.util.RedisUtils;
import com.fastree.oa.service.system.domain.SystemUser;
import com.wf.captcha.base.Captcha;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CodeProvider codeProvider;
    private final JwtProvider jwtProvider;
    private final RedisUtils redisUtils;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping(value = "/login")
    public Result login(@RequestBody SystemUser systemUser) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(systemUser.getUsername(), systemUser.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

//        boolean rememberMe = (loginDto.isRememberMe() == null) ? false : loginDto.isRememberMe();
        String jwt = jwtProvider.createToken(authentication, false);


        return Result.ok().data("token", jwt);
    }

    @GetMapping(value = "/info")
    public Result info(String token) {
        System.out.println(token);

        return Result.ok();
    }

    @GetMapping(value = "/code")
    public Result code() {
        Captcha captcha = codeProvider.getCaptcha();
        CodeProperties codeProperties = codeProvider.getCodeProperties();
        String uuid = codeProperties.getCodePrefix() + IdUtil.simpleUUID();
        // 处理计算结果为浮点数
        String captchaValue = captcha.text();
        if (captcha.getCharType() - 1 == CodeEnum.arithmetic.ordinal() && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }
        // todo 保存验证码到redis中
        redisUtils.set(uuid, captchaValue, codeProperties.getExpires(), TimeUnit.MINUTES);
        return Result.ok().data("uuid", uuid).data("img", captcha.toBase64());
    }

    @PostMapping(value = "/logout")
    public Result logout() {
        return Result.ok();
    }
}
