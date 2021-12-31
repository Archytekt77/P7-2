package com.loicmaria.webapp.form;

import lombok.Data;

@Data
public class UserForm {

    private String username;

    private String mail;

    private String password;

    private int idRole;
}
