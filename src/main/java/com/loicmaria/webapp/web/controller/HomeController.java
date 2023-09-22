package com.loicmaria.webapp.web.controller;


import com.loicmaria.webapp.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    /**
     * Afficher la page d'accueil.
     * @return La page d'accueil.
     */
    @GetMapping("/home")
    public String main() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            return "home";
        }
        model.addAttribute("user", new User());
        return "/login";
    }




}