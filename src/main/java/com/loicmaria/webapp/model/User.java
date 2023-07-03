package com.loicmaria.webapp.model;

import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class User {

    private int id;

    private String username;

    private String mail;

    private String password;

    private List<Role> roleList;

    private Collection<Loan> loanCollection;


}