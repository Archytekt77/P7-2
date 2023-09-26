package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.Book;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Data
@Service
public class BookService {

    @Autowired
    ApiProxy apiProxy;



    public Book getBook(int id){return apiProxy.getBook(id);}

    public Collection<Book> getBooks(){return apiProxy.getBooks();}


    /**
     * <b>Retourne une liste de livres pour le système de recherche.</b>
     * Permet de trouver les livres en prenant le titre.
     * @param title Le titre du livre qui doit être trouvé.
     * @return Une liste de livres.
     */
    public Collection<Book> findByTitle(String title){
        return apiProxy.getBooksBySearch(title);
    }

}
