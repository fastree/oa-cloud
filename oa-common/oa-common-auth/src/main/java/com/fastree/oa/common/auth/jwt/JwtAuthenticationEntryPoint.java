package com.fastree.oa.common.auth.jwt;

import com.fastree.oa.common.base.domain.Result;
import com.fastree.oa.common.base.domain.ResultEnum;
import com.fastree.oa.common.base.utils.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtils.out(response, Result.custom(ResultEnum.TOKEN_AUTH_EXCEPTION));
    }
}
