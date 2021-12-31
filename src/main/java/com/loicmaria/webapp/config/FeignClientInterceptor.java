package com.loicmaria.webapp.config;

import com.loicmaria.webapp.service.JwtService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER="Authorization";
    private static final String TOKEN_TYPE = "Bearer";

    @Autowired
    JwtService jwtService;

    @Override
    public void apply(RequestTemplate requestTemplate) {

        if(jwtService.getJwtResponse() != null){
            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, jwtService.getJwtResponse().getJwtToken()));
        }

    }
}
