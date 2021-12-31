package com.loicmaria.webapp.model;


import lombok.Data;

import java.util.Collection;

@Data
public class Role {

    private int id;

    private String name;

    private Collection<User> userCollection;

}
