package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.form.LoanForm;
import com.loicmaria.webapp.model.Loan;
import com.loicmaria.webapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanService loanService;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("title", "Prêt");
        model.addAttribute("URL", "loans");
        model.addAttribute("fragment", "fragments/model/loan");
        model.addAttribute("searchSystem", false);
    }

    //Create
    @GetMapping("/create")
    public String createLoan(Model model){
        model.addAttribute("object", new LoanForm());
        return "crud/createSomething";
    }

    @PostMapping("/create")
    public String addLoan(@ModelAttribute LoanForm loanForm, Model model) {
        loanService.createLoan(loanForm);
        model.addAttribute("objectList", loanService.getLoans());
        return "crud/getSomething";
    }

    //Get by ID
    @GetMapping("/details")
    public String getLoanById(@RequestParam(value= "id") int id, Model model){
        model.addAttribute("object", loanService.getLoan(id));
        return "crud/detailsSomething";
    }

    //Get all
    @GetMapping
    public String getLoans(Model model){
        model.addAttribute("objectList", loanService.getLoans());
        return "crud/getSomething";
    }

    //Update
    @GetMapping("/edition")
    public String editionLoan(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", loanService.getLoan(id));
        return "crud/editionSomething";
    }

    @PostMapping("/edition/{id}")
    public String updateLoan(@PathVariable(value = "id") int id, Model model, LoanForm loanForm){
        loanService.updateLoan(id, loanForm);
        model.addAttribute("object", loanService.getLoan(id));
        return "crud/detailsSomething";
    }

    //Delete
    @GetMapping("/delete")
    public String deleteLoan(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", loanService.getLoan(id));
        loanService.deleteLoan(id);
        return "crud/deleteSomething";
    }

}
