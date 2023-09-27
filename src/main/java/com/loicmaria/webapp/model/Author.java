package com.loicmaria.webapp.model;

import lombok.Data;
import java.util.Collection;

@Data
public class Author {

    private int id;

    private String firstName;

    private String lastName;

    private Collection<Book> bookCollection;
}
