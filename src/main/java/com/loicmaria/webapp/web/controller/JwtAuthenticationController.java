package com.loicmaria.webapp.web.controller;


import com.loicmaria.webapp.model.JwtRequest;
import com.loicmaria.webapp.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class JwtAuthenticationController {

    @Autowired
    JwtService jwtService;

    @PostMapping("/authenticate")
    public String login(){
        System.out.println("login");

        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("test");
        jwtRequest.setPassword("test");

        jwtService.createAuthenticationToken(jwtRequest);

        return "home";
    }

}
