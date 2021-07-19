package com.loicmaria.webapp.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Book {

    private int id;

    private String title;

    private String collection;

    private String summary;

    private String language;

    private Date publication;


    protected void prePersist() {
        if (this.createDate == null) createDate = LocalDateTime.now();
    }

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
