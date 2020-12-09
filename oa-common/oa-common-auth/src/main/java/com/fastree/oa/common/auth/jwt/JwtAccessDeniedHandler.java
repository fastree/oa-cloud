package com.fastree.oa.common.auth.jwt;

import com.fastree.oa.common.base.domain.Result;
import com.fastree.oa.common.base.domain.ResultEnum;
import com.fastree.oa.common.base.utils.ResponseUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseUtils.out(response, Result.custom(ResultEnum.TOKEN_ACCESS_EXCEPTION));
    }
}
