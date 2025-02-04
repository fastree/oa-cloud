package com.fastree.oa.common.base.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {

    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public Result() {
    }

    public static Result ok() {
        Result r = new Result();
        r.setSuccess(ResultEnum.SUCCESS.getSuccess());
        r.setCode(ResultEnum.SUCCESS.getCode());
        r.setMessage(ResultEnum.SUCCESS.getMessage());
        return r;
    }

    public static Result error() {
        Result r = new Result();
        r.setSuccess(ResultEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultEnum.UNKNOWN_REASON.getMessage());
        return r;
    }

    public static Result custom(ResultEnum resultEnum) {
        Result r = new Result();
        r.setSuccess(resultEnum.getSuccess());
        r.setCode(resultEnum.getCode());
        r.setMessage(resultEnum.getMessage());
        return r;
    }

    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}