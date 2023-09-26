package com.loicmaria.webapp.config.security;

import com.loicmaria.webapp.model.User;
import com.loicmaria.webapp.proxies.ApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetails implements UserDetailsService {


    @Autowired
    private ApiProxy apiProxy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = apiProxy.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return user;
    }
}
