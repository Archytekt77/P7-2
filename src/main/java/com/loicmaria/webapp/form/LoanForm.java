package com.loicmaria.webapp.form;

import lombok.Data;


@Data
public class LoanForm {

    private String status;

    private boolean extraTime;

    private int idBook;

    private int idUser;
}
