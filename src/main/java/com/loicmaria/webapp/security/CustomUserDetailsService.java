package com.loicmaria.webapp.security;

import java.util.Collection;


import com.loicmaria.webapp.model.User;
import com.loicmaria.webapp.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
//@Transactional
public class CustomUserDetailsService{
/*
    @Autowired
    private UserProxy userProxy;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userProxy.getUser().getUsername();
                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(userAccount.getEmail(), userAccount.getPassword(),
                getAuthorities(userAccount));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(UserAccount userAccount) {
        String[] userAccountRoles = userAccount.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userAccountRoles);
        return authorities;
    }*/
}