package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.form.AuthorForm;
import com.loicmaria.webapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("title", "Auteur");
        model.addAttribute("URL", "authors");
        model.addAttribute("fragment", "fragments/model/author");
        model.addAttribute("searchSystem", false);
    }

    //Create
    @GetMapping("/create")
    public String createAuthor(Model model){
        model.addAttribute("object", new AuthorForm());
        return "crud/createSomething";
    }

    @PostMapping("/create")
    public String addAuthor(@ModelAttribute AuthorForm authorForm, Model model) {
        authorService.createAuthor(authorForm);
        model.addAttribute("objectList", authorService.getAuthors());
        return "crud/getSomething";
    }

    //Get by ID
    @GetMapping("/details")
    public String getAuthorById(@RequestParam(value= "id") int id, Model model){
        model.addAttribute("object", authorService.getAuthor(id));
        return "crud/detailsSomething";
    }

    //Get all
    @GetMapping
    public String getAuthors(Model model){
        model.addAttribute("objectList", authorService.getAuthors());
        return "crud/getSomething";
    }

    //Update
    @GetMapping("/edition")
    public String editionAuthor(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", authorService.getAuthor(id));
        return "crud/editionSomething";
    }

    @PostMapping("/edition/{id}")
    public String updateAuthor(@PathVariable(value = "id") int id, Model model, AuthorForm authorForm){
        authorService.updateAuthor(id, authorForm);
        model.addAttribute("object", authorService.getAuthor(id));
        return "crud/detailsSomething";
    }

    //Delete
    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", authorService.getAuthor(id));
        authorService.deleteAuthor(id);
        return "crud/deleteSomething";
    }

}
