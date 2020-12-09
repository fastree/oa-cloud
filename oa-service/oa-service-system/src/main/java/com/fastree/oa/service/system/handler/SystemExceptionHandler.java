package com.fastree.oa.service.system.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.fastree.oa.common.base.domain.Result;
import com.fastree.oa.common.base.domain.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public Result error(BadCredentialsException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return Result.custom(ResultEnum.TOKEN_AUTH_EXCEPTION);
    }
}
