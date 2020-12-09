package com.fastree.oa.service.system.service.impl;

import com.fastree.oa.service.system.domain.SecurityUser;
import com.fastree.oa.service.system.domain.SystemUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = new SystemUser(1001l, "admin", "1001", new BCryptPasswordEncoder().encode("111111"), true, true, true, true, "admin", LocalDateTime.now(), null, null, null);
        SecurityUser securityUser = new SecurityUser(systemUser);
        securityUser.setAuthorities(Arrays.asList("user:list", "user:add", "user:update", "user:delete"));
        return securityUser;
    }
}
