package com.fastree.oa.common.base.exception;

import com.fastree.oa.common.base.domain.ResultEnum;
import lombok.Data;

@Data
public class CaptchaException extends RuntimeException {
    private Integer code;
    private String msg;

    public CaptchaException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public CaptchaException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
