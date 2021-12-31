package com.loicmaria.webapp.model;

import lombok.Data;

import java.util.Collection;

@Data
public class User {

    private int id;

    private String username;

    private String mail;

    private String password;

    private Role role;

    private Collection<Loan> loanCollection;


}