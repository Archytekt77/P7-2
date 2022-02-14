package com.loicmaria.webapp.service;

import com.loicmaria.webapp.form.UserForm;
import com.loicmaria.webapp.model.User;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Data
@Service
public class UserService {

    @Autowired
    ApiProxy apiProxy;

    public User convertUserFormToUser(UserForm userForm){
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setMail(userForm.getMail());
        user.setPassword(userForm.getPassword());
        return user;
    }

    public User createUser(UserForm userForm){
        User user = this.convertUserFormToUser(userForm);
        System.out.println("User : " + user);
        return apiProxy.createUser(user);
    }

    public User getUser(int id) {
        return apiProxy.getUser(id);
    }

    public Collection<User> getUsers() {
        return apiProxy.getUsers();
    }

    public User updateUser(int id, UserForm userForm){
        User user = this.convertUserFormToUser(userForm);
        return apiProxy.updateUser(id, user);
    }

    public void deleteUser(int id) {
        apiProxy.deleteUser(id);
    }

    public User getLoggedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User user = apiProxy.getLoggedUser(userName);
        if(user != null){
            return user;
        }
        return null;
    }

}
