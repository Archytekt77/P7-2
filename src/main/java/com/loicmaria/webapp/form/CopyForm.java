package com.loicmaria.webapp.form;

import lombok.Data;


@Data
public class CopyForm {

    private int copies;

    private String publisherName;

    private String publicationDate;

    private int idBook;

    private int idType;


}
