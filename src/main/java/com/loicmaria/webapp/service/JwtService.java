package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.JwtRequest;
import com.loicmaria.webapp.model.JwtResponse;
import com.loicmaria.webapp.model.User;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class JwtService{

    @Autowired
    ApiProxy apiProxy;

    private JwtResponse jwtResponse;

    private User user;

    public JwtResponse createAuthenticationToken(JwtRequest jwtRequest){
        jwtResponse = apiProxy.createAuthenticationToken(jwtRequest);
        this.user = jwtResponse.getUser();
        System.out.println(jwtResponse);
        return jwtResponse;
    }



}
