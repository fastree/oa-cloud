package com.fastree.oa.common.base.exception;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private Integer code;
    private String msg;

    public GlobalException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
