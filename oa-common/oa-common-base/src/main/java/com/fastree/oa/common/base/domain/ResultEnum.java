package com.fastree.oa.common.base.domain;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "发生未知错误"),
    TOKEN_AUTH_EXCEPTION(false, 20002, "用户认证失败"),
    TOKEN_ACCESS_EXCEPTION(false, 20003, "没有权限访问"),
    CAPTCHA_CONFIG_EXCEPTION(false, 20004, "没有权限访问");

    private Boolean success;
    private Integer code;
    private String message;

    ResultEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}