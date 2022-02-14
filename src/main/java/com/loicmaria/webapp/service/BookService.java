package com.loicmaria.webapp.service;

import com.loicmaria.webapp.form.BookForm;
import com.loicmaria.webapp.model.Book;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Data
@Service
public class BookService {

    @Autowired
    ApiProxy apiProxy;


    public Book convertBookFormToBook(Book book,BookForm bookForm){
        book.setTitle(bookForm.getTitle());
        book.setCollection(bookForm.getCollection());
        book.setSummary(bookForm.getSummary());
        book.setLanguage(bookForm.getLanguage());
        book.setPublicationDate(this.convertStringToDate(bookForm));
        book.setAuthor(apiProxy.getAuthor(bookForm.getIdAuthor()));

        return book;
    }

    public BookForm convertBookToBookForm (Book book){
        BookForm bookForm = new BookForm();

        bookForm.setTitle(book.getTitle());
        bookForm.setCollection(book.getCollection());
        bookForm.setSummary(book.getSummary());
        bookForm.setLanguage(book.getLanguage());
        bookForm.setPublicationDate(this.convertDateToString(book));
        bookForm.setIdAuthor(book.getAuthor().getId());

        return bookForm;
    }

    public Date convertStringToDate(BookForm bookForm){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = formatter.parse(bookForm.getPublicationDate());
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String convertDateToString(Book book){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = book.getPublicationDate();

        String dateToStr = dateFormat.format(date);

        return dateToStr;
    }

    public Book createBook(BookForm bookForm){
        Book book = this.convertBookFormToBook(new Book(), bookForm);
        return apiProxy.createBook(book);
    }

    public Book getBook(int id){return apiProxy.getBook(id);}

    public Collection<Book> getBooks(){return apiProxy.getBooks();}

    public Book updateBook(int id, BookForm bookForm){
        Book book = this.convertBookFormToBook(this.getBook(id), bookForm);
        return apiProxy.updateBook(id, book);
    }

    public void deleteBook(int id){apiProxy.deleteBook(id);}

    /**
     * <b>Retourne une liste de livres pour le système de recherche.</b>
     * Permet de trouver les livres en prenant le titre + la langue.
     * @param title Le titre du livre qui doit être trouvé.
     * @param language La langue du livre qui doit être trouvé.
     * @return Une liste de livres.
     */
    public Collection<Book> findByTitleAndLanguage(String title, String language){
        return apiProxy.getBooksBySearch(title,language);
    }

}
