package com.fastree.oa.service.system.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SecurityUser implements UserDetails {

    private transient SystemUser systemUser;
    private List<String> authorities = new ArrayList<>();

    public SecurityUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream()
                .filter(authority -> !StringUtils.isEmpty(authority))
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.systemUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.systemUser.getUserNo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.systemUser.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.systemUser.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.systemUser.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.systemUser.isEnabled();
    }
}
