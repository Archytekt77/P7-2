package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.model.Booking;
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


    @PostMapping("/create")
    public String addBooking(@RequestBody int userId, @RequestBody int copyId) {
       // bookingService.createBooking(userId, copyId);
        return "book/getBooks";
    }


    @PutMapping("/extend")
    public String extendBooking(@RequestBody Booking booking){
        bookingService.extendBooking(booking);
        return "";
    }




    @GetMapping("/get")
    public String getBookingsByUser(Model model){
        int userId = userService.getLoggedUser().getId();
        model.addAttribute("inProgressBookings", bookingService.findByUser_IdAndStatus(userId, "inProgress"));
        model.addAttribute("extendBookings", bookingService.findByUser_IdAndStatus(userId,"extend"));
        model.addAttribute("finishedBookings", bookingService.findByUser_IdAndStatus(userId, "finish"));
        return "getBookings";
    }

}
