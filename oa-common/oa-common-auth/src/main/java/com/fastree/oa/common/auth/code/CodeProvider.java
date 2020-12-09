package com.fastree.oa.common.auth.code;

import com.fastree.oa.common.base.domain.ResultEnum;
import com.fastree.oa.common.base.exception.CaptchaException;
import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.awt.*;

@Data
public class CodeProvider {
    /**
     * 账号单用户登录
     */
    private boolean singleLogin = false;

    /**
     * 用户登录信息缓存
     */
    private boolean cacheEnable;

    /**
     * 验证码的配置类
     */
    private CodeProperties codeProperties;

    public CodeProvider(CodeProperties codeProperties) {
        this.codeProperties = codeProperties;
    }

    /**
     * 获取验证码生产类
     *
     * @return /
     */
    public Captcha getCaptcha() {
        return switchCaptcha(codeProperties);
    }

    /**
     * 依据配置信息生产验证码
     *
     * @param codeProperties 验证码配置信息
     * @return /
     */
    private Captcha switchCaptcha(CodeProperties codeProperties) {
        Captcha captcha;
        synchronized (this) {
            switch (codeProperties.getCodeType()) {
                case arithmetic:
                    // 算术类型 https://gitee.com/whvse/EasyCaptcha
                    captcha = new ArithmeticCaptcha(codeProperties.getWidth(), codeProperties.getHeight());
                    captcha.setLen(codeProperties.getLength());
                    break;
                case chinese:
                    captcha = new ChineseCaptcha(codeProperties.getWidth(), codeProperties.getHeight());
                    captcha.setLen(codeProperties.getLength());
                    break;
                case chinese_gif:
                    captcha = new ChineseGifCaptcha(codeProperties.getWidth(), codeProperties.getHeight());
                    captcha.setLen(codeProperties.getLength());
                    break;
                case gif:
                    captcha = new GifCaptcha(codeProperties.getWidth(), codeProperties.getHeight());
                    captcha.setLen(codeProperties.getLength());
                    break;
                case spec:
                    captcha = new SpecCaptcha(codeProperties.getWidth(), codeProperties.getHeight());
                    captcha.setLen(codeProperties.getLength());
                    break;
                default:
                    throw new CaptchaException(ResultEnum.CAPTCHA_CONFIG_EXCEPTION);
            }
        }
        if (!StringUtils.isEmpty(codeProperties.getFontName())) {
            captcha.setFont(new Font(codeProperties.getFontName(), Font.PLAIN, codeProperties.getFontSize()));
        }

        return captcha;
    }
}
