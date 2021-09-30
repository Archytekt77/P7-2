package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.model.JwtRequest;
import com.loicmaria.webapp.model.JwtResponse;
import com.loicmaria.webapp.service.BookService;
import com.loicmaria.webapp.service.JwtService;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    JwtService jwtService;


    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable(value= "id") int id, Model model){
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername("test");
        jwtRequest.setPassword("test");
        System.out.println(id);
        model.addAttribute("book", bookService.get(id));
        return "book";
    }

}
