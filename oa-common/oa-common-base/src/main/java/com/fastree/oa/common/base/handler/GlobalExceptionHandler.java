package com.fastree.oa.common.base.handler;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.fastree.oa.common.base.domain.Result;
import com.fastree.oa.common.base.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public Result handleGlobalException(GlobalException e) {
        log.error(ExceptionUtil.stacktraceToString(e));
        return Result.error().code(e.getCode()).message(e.getMessage());
    }
}
