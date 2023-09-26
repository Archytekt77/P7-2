package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.form.BookingForm;
import com.loicmaria.webapp.service.BookingService;
import com.loicmaria.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;


    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("title", "Prêt");
        model.addAttribute("URL", "bookings");
        model.addAttribute("fragment", "fragments/model/booking");
        model.addAttribute("searchSystem", false);
        model.addAttribute("user", userService.getLoggedUser());
    }

    //Create
    @GetMapping("/create")
    public String createBooking(Model model){
        model.addAttribute("object", new BookingForm());
        return "crud/createSomething";
    }

    @PostMapping("/create")
    public String addBooking(@ModelAttribute BookingForm bookingForm, Model model) {
        bookingService.createBooking(bookingForm);
        model.addAttribute("objectList", bookingService.getBookings());
        return "crud/getSomething";
    }

    /*//Get by ID
    @GetMapping("/details")
    public String getBookingById(@RequestParam(value= "id") int id, Model model){
        model.addAttribute("object", bookingService.getBooking(id));
        return "crud/detailsSomething";
    }*/

    /*//Get all
    @GetMapping
    public String getBookings(Model model){
        model.addAttribute("objectList", bookingService.getBookings());
        return "crud/getSomething";
    }*/

    //Update
    @GetMapping("/edition")
    public String editionBooking(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", bookingService.getBooking(id));
        return "crud/editionSomething";
    }

    @PostMapping("/edition/{id}")
    public String updateBooking(@PathVariable(value = "id") int id, Model model, BookingForm bookingForm){
        bookingService.updateBooking(id, bookingForm);
        model.addAttribute("object", bookingService.getBooking(id));
        return "crud/detailsSomething";
    }

    /*//Delete
    @GetMapping("/delete")
    public String deleteBooking(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("object", bookingService.getBooking(id));
        bookingService.deleteBooking(id);
        return "crud/deleteSomething";
    }*/

    /*@GetMapping("/get")
    public String getBookingsByUser(Model model){
        model.addAttribute("objectList", userService.findByUser_Id(userService.getLoggedUser().getId()));
        return "crud/getsomething";
    }*/

}
