package com.fastree.oa.service.system.mapstruct.dto;

import com.fastree.oa.service.system.entity.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto implements UserDetails {

    private UserEntity userEntity;
    private List<String> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream()
                .filter(authority -> !StringUtils.isEmpty(authority))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userEntity.getIsAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userEntity.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userEntity.getIsCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userEntity.getIsEnabled();
    }
}
