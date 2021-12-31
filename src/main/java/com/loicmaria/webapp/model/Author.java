package com.loicmaria.webapp.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
public class Author {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Collection<Book> bookCollection;
}
