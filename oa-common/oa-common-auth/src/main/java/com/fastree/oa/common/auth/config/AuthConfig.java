package com.fastree.oa.common.auth.config;

import com.fastree.oa.common.auth.code.CodeProperties;
import com.fastree.oa.common.auth.code.CodeProvider;
import com.fastree.oa.common.auth.jwt.JwtProperties;
import com.fastree.oa.common.auth.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({CodeProperties.class, JwtProperties.class})
public class AuthConfig {

    @Autowired
    private CodeProperties codeProperties;

    @Autowired
    private JwtProperties jwtProperties;

    @Bean
    public CodeProvider codeProvider() {
        return new CodeProvider(codeProperties);
    }

    @Bean
    public JwtProvider jwtProvider() {
        return new JwtProvider(jwtProperties);
    }
}
