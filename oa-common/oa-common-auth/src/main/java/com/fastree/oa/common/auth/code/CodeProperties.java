package com.fastree.oa.common.auth.code;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "auth.code")
public class CodeProperties {
    /**
     * 验证码配置
     */
    private CodeEnum codeType = CodeEnum.arithmetic;
    /**
     * 验证码有效期 分钟
     */
    private Long expires = 2L;
    /**
     * 验证码内容长度
     */
    private int length = 2;
    /**
     * 验证码宽度
     */
    private int width = 111;
    /**
     * 验证码高度
     */
    private int height = 36;
    /**
     * 验证码字体
     */
    private String fontName;
    /**
     * 字体大小
     */
    private int fontSize = 25;

    /**
     * 验证码的前缀
     */
    private String codePrefix = "captcha-key-";

}
