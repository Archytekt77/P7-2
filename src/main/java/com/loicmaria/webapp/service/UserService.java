package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.User;
import com.loicmaria.webapp.proxy.UserProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public abstract class UserService {

    @Autowired
    UserProxy userProxy;

    public User getUser(int id) {
        return userProxy.getUser(id);
    }

    public Iterable<User> getUsers() {
        return userProxy.getUsers();
    }

    public void deleteUser(final int id) {
        userProxy.deleteUser(id);
    }

}
