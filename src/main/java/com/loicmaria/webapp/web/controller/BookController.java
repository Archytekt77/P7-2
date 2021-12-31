package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.form.BookForm;
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

    //Create
    @GetMapping("/create")
    public String createBook(Model model){

        String searchSystem = null;

        model.addAttribute("searchSystem", searchSystem);
        model.addAttribute("object", new BookForm());
        model.addAttribute("authorsList", authorService.getAuthors());
        return "crud/createSomething";
    }

    @PostMapping("/create")
    public String addBook(@ModelAttribute BookForm bookForm, Model model) {
        System.out.println("Book : " + bookForm);
        bookService.createBook(bookForm);
        model.addAttribute("objectList", bookService.getBooks());
        return "crud/getSomething";
    }

    //Get by ID
    @GetMapping("/details")
    public String getBookById(@RequestParam(value= "id") int id, Model model){
        model.addAttribute("object", bookService.getBook(id));
        return "crud/detailsSomething";
    }

    //Get all
    @GetMapping
    public String getBooks(Model model){
        model.addAttribute("searchBook", new Book());
        String searchSystem = "ok";
        model.addAttribute("searchSystem", searchSystem);
        model.addAttribute("objectList", bookService.getBooks());
        return "crud/getSomething";
    }


    /**
     * Afficher la liste des livres avec le système de recherche.
     * @param title Le titre du livre recherché.
     * @param language La langue du livre recherché.
     * @param model Contient les données à afficher.
     * @return La page avec la liste des livres.
     */
    @PostMapping("/{title}/{language}")
    public String getBooksBySearch(String title, String language, Model model) {
        System.out.println("Titre + langue " + title + " " + language);

        Book book = new Book();
        book.setTitle(title);
        book.setLanguage(language);

        System.out.println("Book : " + book);

        model.addAttribute("searchSystem", true);
        model.addAttribute("searchBook", book);
        model.addAttribute("bookList", bookService.findByTitleAndLanguage(title, language));
        return "crud/getSomething";
    }

    //Update
    @GetMapping("/edition")
    public String editionBook(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", bookService.getBook(id));
        model.addAttribute("authorsList", authorService.getAuthors());
        return "crud/editionSomething";
    }

    @PostMapping("/edition/{id}")
    public String updateBook(@PathVariable(value = "id") int id, Model model, BookForm bookForm){
        bookService.updateBook(id, bookForm);
        model.addAttribute("object", bookService.getBook(id));
        return "crud/detailsSomething";
    }

    //Delete
    @GetMapping("/delete")
    public String deleteBook(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", bookService.getBook(id));
        bookService.deleteBook(id);
        return "crud/deleteSomething";
    }

}
