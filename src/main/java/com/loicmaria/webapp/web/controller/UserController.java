package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.form.UserForm;
import com.loicmaria.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/details")
    public String getUserById(Model model){
        model.addAttribute("user", userService.getLoggedUser());
        return "user/detailsUser";
    }

    @GetMapping("/create")
    public String userForm(Model model){
        model.addAttribute("user", new UserForm());
        return "user/createUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute UserForm userForm){
        userService.createUser(userForm);
        return "login";
    }

}
