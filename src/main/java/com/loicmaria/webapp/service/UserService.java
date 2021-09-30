package com.loicmaria.webapp.service;

import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Data
@Service
public abstract class UserService {

    @Autowired
    ApiProxy apiProxy;

    /*public User getUser(int id) {
        return userProxy.getUser(id);
    }

    public Collection<User> getUsers() {
        return userProxy.getUsers();
    }

    public void deleteUser(final int id) {
        userProxy.deleteUser(id);
    }*/

}
