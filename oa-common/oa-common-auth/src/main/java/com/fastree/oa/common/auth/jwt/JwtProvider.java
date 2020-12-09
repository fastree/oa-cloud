package com.fastree.oa.common.auth.jwt;

import cn.hutool.core.util.IdUtil;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtProvider implements InitializingBean {

    private final Logger log = LoggerFactory.getLogger(JwtProvider.class);
    private JwtProperties properties;
    private JwtParser jwtParser;
    private JwtBuilder jwtBuilder;

    public JwtProvider(JwtProperties jwtProperties) {
        this.properties = jwtProperties;
    }

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(properties.getBase64Secret());
        Key key = Keys.hmacShaKeyFor(keyBytes);
        this.jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        this.jwtBuilder = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS512);
    }

    public String createToken(Authentication authentication, boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + properties.getRememberMeExpires());
        } else {
            validity = new Date(now + properties.getTokenExpires());
        }

        return this.jwtBuilder
                .setId(IdUtil.simpleUUID())
                .setSubject(authentication.getName())
                .claim(properties.getAuthoritiesKey(), authorities)
                .setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token) {

        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        String[] authoritiesArr = claims.get(properties.getAuthoritiesKey()).toString().split(",");
        Collection<? extends GrantedAuthority> authorities = authoritiesArr.length > 0 ?
                Arrays.stream(authoritiesArr).map(SimpleGrantedAuthority::new).collect(Collectors.toList()) : Collections.emptyList();

        User principal = new User(claims.getSubject(), "******", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            jwtParser.parseClaimsJws(authToken);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {}", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }
}
