package com.loicmaria.webapp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Collection;
import java.util.Date;

@Data
public class Book {

    private int id;

    private String title;

    private String summary;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publicationDate;

    private Author author;

    private Collection<Copy> copyCollection;
}
