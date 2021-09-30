package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.JwtRequest;
import com.loicmaria.webapp.model.JwtResponse;
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

    public JwtResponse createAuthenticationToken(JwtRequest jwtRequest){
        jwtResponse = apiProxy.createAuthenticationToken(jwtRequest);
        return jwtResponse;
    }



}
