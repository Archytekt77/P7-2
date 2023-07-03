package com.loicmaria.webapp.service;


import com.loicmaria.webapp.model.Author;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Data
@Service
public class AuthorService {

    @Autowired
    ApiProxy apiProxy;


    public Author getAuthor(int id){
        return apiProxy.getAuthor(id);
    }

    public Collection<Author> getAuthors(){
        return apiProxy.getAuthors();
    }


}
