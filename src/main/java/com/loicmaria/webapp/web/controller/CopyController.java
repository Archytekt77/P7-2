package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.model.Copy;
import com.loicmaria.webapp.service.BookService;
import com.loicmaria.webapp.service.CopyService;
import com.loicmaria.webapp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/copies")
public class CopyController {

    @Autowired
    CopyService copyService;
    @Autowired
    BookService bookService;
    @Autowired
    TypeService typeService;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("title", "Exemplaire");
        model.addAttribute("URL", "copies");
        model.addAttribute("fragment", "fragments/model/copy");
    }


    //Get by ID
    @GetMapping("/details")
    public String getCopyById(@RequestParam(value= "id") int id, Model model){
        model.addAttribute("object", copyService.getCopy(id));

        System.out.println(copyService.getCopy(id));
        return "crud/detailsSomething";
    }

    //Get all
    @GetMapping
    public String getCopys(Model model){
        model.addAttribute("objectList", copyService.getCopies());
        return "crud/getSomething";
    }

    //Update
    @GetMapping("/edition")
    public String editionCopy(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", copyService.getCopy(id));
        model.addAttribute("booksList", bookService.getBooks());
        model.addAttribute("typesList", typeService.getTypes());
        return "crud/editionSomething";
    }

    @PostMapping("/edition/{id}")
    public String updateCopy(@PathVariable(value = "id") int id, Model model, Copy copy){
        copyService.updateCopy(id, copy);
        model.addAttribute("object", copyService.getCopy(id));
        return "crud/detailsSomething";
    }


}
