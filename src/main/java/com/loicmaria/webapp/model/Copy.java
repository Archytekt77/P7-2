package com.loicmaria.webapp.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Copy {

    private int id;

    private int copies;

    private String publisherName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publicationDate;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Book bookDto;

    private Type typeDto;


}
