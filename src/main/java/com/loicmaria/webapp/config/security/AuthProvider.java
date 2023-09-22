package com.loicmaria.webapp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthProvider extends DaoAuthenticationProvider {

    @Autowired
    private MyUserDetails myUserDetails;

    @Override
    public Authentication authenticate(Authentication authentication){
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
        String username = authToken.getName();
        String password = authToken.getCredentials().toString();
        UserDetails user = myUserDetails.loadUserByUsername(username);

        if(user == null){
            throw new BadCredentialsException("User not found with username: " + authToken.getPrincipal());
        }

        return new UsernamePasswordAuthenticationToken(user, user.getPassword(),user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
