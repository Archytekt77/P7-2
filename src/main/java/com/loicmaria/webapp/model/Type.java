package com.loicmaria.webapp.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Type {

    private int id;

    private String name;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
