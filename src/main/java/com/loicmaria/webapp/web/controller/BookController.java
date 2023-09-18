package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.model.Book;
import com.loicmaria.webapp.service.AuthorService;
import com.loicmaria.webapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("title", "Livre");
        model.addAttribute("URL", "books");
        model.addAttribute("fragment", "fragments/model/book");
    }


    //Get by ID
    @GetMapping("/details")
    public String getBookById(@RequestParam(value= "id") int id, Model model){
        model.addAttribute("object", bookService.getBook(id));
        return "crud/detailsSomething";
    }

    //Get all
    @GetMapping("/all")
    public String getBooks(Model model){
        model.addAttribute("objectList", bookService.getBooks());
        model.addAttribute("searchBook", new Book());
        model.addAttribute("searchSystem", "ok");
        return "crud/getSomething";
    }


    /**
     * Afficher la liste des livres avec le système de recherche.
     * @param title Le titre du livre recherché.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des livres.
     */
    @PostMapping("/{title}")
    public String getBooksBySearch(String title, Model model) {
        System.out.println("Titre" + title);

        Book book = new Book();
        book.setTitle(title);

        System.out.println("Book : " + book);

        model.addAttribute("searchBook", book);
        model.addAttribute("objectList", bookService.findByTitle(title));
        return "crud/getSomething";
    }

}
