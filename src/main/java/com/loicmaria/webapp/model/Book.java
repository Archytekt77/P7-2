package com.loicmaria.webapp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Data
public class Book {

    private int id;

    private String title;

    private String collection;

    private String summary;

    private String language;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publicationDate;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Author author;

    private Collection<Copy> copyCollection;
}
