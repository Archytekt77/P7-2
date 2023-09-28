package com.loicmaria.webapp.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Booking {

    private int id;

    private String status;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean extraTime;

    private Copy copy;

    private User user;
}
