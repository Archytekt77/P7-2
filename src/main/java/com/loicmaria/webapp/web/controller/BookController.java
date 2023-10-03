package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.model.Book;
import com.loicmaria.webapp.service.BookService;
import com.loicmaria.webapp.service.CopyService;
import com.loicmaria.webapp.service.UserService;
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
    CopyService copyService;
    @Autowired
    UserService userService;


    /**
     * Afficher tous les livres.
     *
     * @param model Contient les données à afficher.
     * @return Affiche la liste des livres.
     */
    @GetMapping("/all")
    public String getBooks(Model model) {
        model.addAttribute("booksList", bookService.getBooks());
        model.addAttribute("searchBook", new Book());
        return "book/getBooks";
    }

    /**
     * Afficher le détail d'un livre avec ses exemplaires correspondants.
     *
     * @param id    L'id du livre.
     * @param model Contient les données à afficher.
     * @return La page détail du livre.
     */
    @GetMapping("/details")
    public String getBook(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("book", bookService.getBook(id));
        model.addAttribute("copiesList", copyService.findByBook_Id(id));
        return "book/detailsBook";
    }


    /**
     * Afficher la liste des livres avec le système de recherche.
     *
     * @param title Le titre du livre recherché.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des livres.
     */
    @PostMapping("/{title}")
    public String getBooksBySearch(String title, Model model) {
        Book book = new Book();
        book.setTitle(title);

        model.addAttribute("searchBook", book);
        model.addAttribute("booksList", bookService.findByTitle(title));
        return "book/getBooks";
    }

}
