package com.loicmaria.webapp.service;

import com.loicmaria.webapp.form.UserForm;
import com.loicmaria.webapp.model.User;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Data
@Service
public class UserService {

    @Autowired
    private ApiProxy apiProxy;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User convertUserFormToUser(UserForm userForm) {
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setMail(userForm.getMail());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        return user;
    }

    public void createUser(UserForm userForm) {
        User user = this.convertUserFormToUser(userForm);
        apiProxy.createUser(user);
    }

    public User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = this.apiProxy.getUserByUsername(username);
        return user;
    }


}
