package com.loicmaria.webapp.form;

import lombok.Data;

@Data
public class BookForm {

    private String title;

    private String collection;

    private String summary;

    private String language;

    private String publicationDate;

    private int idAuthor;
}
