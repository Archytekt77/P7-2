package com.loicmaria.webapp.service;

import com.loicmaria.webapp.form.UserForm;
import com.loicmaria.webapp.model.User;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public void createUser(UserForm userForm){
        User user = this.convertUserFormToUser(userForm);
        System.out.println(user);
        apiProxy.createUser(user);
        System.out.println("ok");
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


}
