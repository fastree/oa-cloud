package com.fastree.oa.service.system.config;


import com.fastree.oa.common.auth.jwt.JwtAccessDeniedHandler;
import com.fastree.oa.common.auth.jwt.JwtAuthenticationEntryPoint;
import com.fastree.oa.common.auth.jwt.JwtConfigurer;
import com.fastree.oa.common.auth.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SystemWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtProvider jwtProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

//                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                .accessDeniedHandler(new JwtAccessDeniedHandler())

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/auth/code").permitAll()
                .antMatchers("/auth/login").permitAll()

                .anyRequest().authenticated()

                .and()
                .apply(securityConfigurerAdapter())
        ;
    }

    private JwtConfigurer securityConfigurerAdapter() {
        return new JwtConfigurer(jwtProvider);
    }
}
