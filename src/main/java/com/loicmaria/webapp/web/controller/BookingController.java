package com.loicmaria.webapp.web.controller;

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
        model.addAttribute("user", userService.getLoggedUser());
    }

    //Create

    @PostMapping("/create")
    public String addBooking(@RequestBody int userId, @RequestBody int copyId, Model model) {
        bookingService.createBooking(userId, copyId);
        return "crud/getSomething";
    }


    /*@GetMapping("/get")
    public String getBookingsByUser(Model model){
        model.addAttribute("objectList", userService.findByUser_Id(userService.getLoggedUser().getId()));
        return "crud/getsomething";
    }*/

}
