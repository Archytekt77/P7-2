package com.loicmaria.webapp.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Booking {

    private int id;

    private String status;

    private boolean extraTime;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Copy copy;

    private User user;
}
