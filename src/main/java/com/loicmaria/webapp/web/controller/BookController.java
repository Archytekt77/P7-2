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


    @GetMapping("/all")
    public String getBooks(Model model) {
        model.addAttribute("booksList", bookService.getBooks());
        model.addAttribute("searchBook", new Book());
        return "book/getBooks";
    }

    @GetMapping("/details")
    public String getBook(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("book", bookService.getBook(id));
        model.addAttribute("copiesList", copyService.findByBook_Id(id));
        return "book/detailsBook";
    }

    //  Système de recherche de livres
    @PostMapping("/{title}")
    public String getBooksBySearch(String title, Model model) {
        Book book = new Book();
        book.setTitle(title);

        model.addAttribute("searchBook", book);
        model.addAttribute("booksList", bookService.findByTitle(title));
        return "book/getBooks";
    }

}
