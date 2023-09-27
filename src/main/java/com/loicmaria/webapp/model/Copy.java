package com.loicmaria.webapp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Copy {

    private int id;

    private int copies;

    private String collection;

    private String language;

    private String publisherName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publicationDate;

    private Book book;

    private Type type;


}
