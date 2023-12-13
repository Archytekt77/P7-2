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


    @PostMapping("/create")
    public String addBooking(@RequestParam("copyId") int copyId, Model model) {
        int userId = userService.getLoggedUser().getId();
        bookingService.createBooking(userId, copyId);
        model.addAttribute("booksList", bookService.getBooks());
        model.addAttribute("searchBook", new Book());
        return "book/getBooks";
    }

    @PostMapping("/extend")
    public String extendBooking(@RequestParam("bookingId") int bookingId, Model model){
        bookingService.extendBooking(bookingId);
        int userId = userService.getLoggedUser().getId();
        model.addAttribute("inProgressBookings", bookingService.findByUserAndStatus(userId, "inProgress"));
        model.addAttribute("extendBookings", bookingService.findByUserAndStatus(userId,"extend"));
        model.addAttribute("finishedBookings", bookingService.findByUserAndStatus(userId, "finish"));
        return "getBookings";
    }

    @GetMapping("/get")
    public String getBookingsByUser(Model model){
        int userId = userService.getLoggedUser().getId();
        model.addAttribute("inProgressBookings", bookingService.findByUserAndStatus(userId, "inProgress"));
        model.addAttribute("extendBookings", bookingService.findByUserAndStatus(userId,"extend"));
        model.addAttribute("finishedBookings", bookingService.findByUserAndStatus(userId, "finish"));
        return "getBookings";
    }

}
