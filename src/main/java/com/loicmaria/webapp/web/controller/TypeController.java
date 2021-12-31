package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.form.TypeForm;
import com.loicmaria.webapp.model.Type;
import com.loicmaria.webapp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/types")
public class TypeController {

    @Autowired
    TypeService typeService;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("title", "Type");
        model.addAttribute("URL", "types");
        model.addAttribute("fragment", "fragments/model/type");
        model.addAttribute("searchSystem", false);
    }

    //Create
    @GetMapping("/create")
    public String createType(Model model){
        model.addAttribute("object", new TypeForm());
        return "crud/createSomething";
    }

    @PostMapping("/create")
    public String addType(@ModelAttribute TypeForm typeForm, Model model) {
        typeService.createType(typeForm);
        model.addAttribute("objectList", typeService.getTypes());
        return "crud/getSomething";
    }

    //Get by ID
    @GetMapping("/details")
    public String getTypeById(@RequestParam(value= "id") int id, Model model){
        model.addAttribute("object", typeService.getType(id));
        return "crud/detailsSomething";
    }

    //Get all
    @GetMapping
    public String getTypes(Model model){
        model.addAttribute("objectList", typeService.getTypes());
        return "crud/getSomething";
    }

    //Update
    @GetMapping("/edition")
    public String editionType(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", typeService.getType(id));
        return "crud/editionSomething";
    }

    @PostMapping("/edition/{id}")
    public String updateType(@PathVariable(value = "id") int id, Model model, TypeForm typeForm){
        typeService.updateType(id, typeForm);
        model.addAttribute("object", typeService.getType(id));
        return "crud/detailsSomething";
    }

    //Delete
    @GetMapping("/delete")
    public String deleteType(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", typeService.getType(id));
        typeService.deleteType(id);
        return "crud/deleteSomething";
    }

}
