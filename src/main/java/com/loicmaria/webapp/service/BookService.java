package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.Book;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class BookService {

    @Autowired
    JwtService jwtService;
    @Autowired
    ApiProxy apiProxy;

    public Book get(int id){
        Book book = apiProxy.getBook(id);
        return book;
    }

}
