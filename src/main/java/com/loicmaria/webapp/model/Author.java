package com.loicmaria.webapp.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Author {

    private int id;

    private String firstName;

    private String lastName;

    protected void prePersist() {
        if (this.createDate == null) createDate = LocalDateTime.now();
    }

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
