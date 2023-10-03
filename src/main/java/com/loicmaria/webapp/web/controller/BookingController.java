package com.loicmaria.webapp.web.controller;

import com.loicmaria.webapp.model.Book;
import com.loicmaria.webapp.service.BookService;
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
    @Autowired
    BookService bookService;


    @PostMapping("/create/{copyId}")
    public String addBooking(@PathVariable int copyId, Model model) {
        int userId = userService.getLoggedUser().getId();
        bookingService.createBooking(userId, copyId);
        model.addAttribute("booksList", bookService.getBooks());
        model.addAttribute("searchBook", new Book());
        return "book/getBooks";
    }


    @PutMapping("/extend/{id}")
    public String extendBooking(@PathVariable("id") int bookingId){
        bookingService.extendBooking(bookingId);
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
