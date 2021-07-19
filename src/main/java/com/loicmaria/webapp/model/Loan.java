package com.loicmaria.webapp.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Loan {

    private int id;

    private String status;

    private boolean extraTime;

    protected void prePersist() {
        if (this.createDate == null) createDate = LocalDateTime.now();
    }

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
