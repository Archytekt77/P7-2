package com.loicmaria.webapp.service;


import com.loicmaria.webapp.form.AuthorForm;
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

    public Author convertAuthorFormToAuthor(Author author, AuthorForm authorForm){
        author.setFirstName(authorForm.getFirstName());
        author.setLastName(authorForm.getLastName());

        return author;
    }

    public Author createAuthor(AuthorForm authorForm){
        Author author = this.convertAuthorFormToAuthor(new Author(), authorForm);
        return apiProxy.createAuthor(author);
    }

    public Author getAuthor(int id){
        return apiProxy.getAuthor(id);
    }

    public Collection<Author> getAuthors(){
        return apiProxy.getAuthors();
    }

    public Author updateAuthor(int id, AuthorForm authorForm){
        Author author = this.convertAuthorFormToAuthor(this.getAuthor(id), authorForm);
        return apiProxy.updateAuthor(id, author);
    }

    public void deleteAuthor(int id){apiProxy.deleteAuthor(id);}

}
