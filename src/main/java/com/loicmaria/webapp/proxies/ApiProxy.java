package com.loicmaria.webapp.proxies;

import com.loicmaria.webapp.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "api", url = "localhost:9000")
public interface ApiProxy{


    //Book

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    Book getBook(@PathVariable("id") int id);

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    Collection<Book> getBooks();

    @RequestMapping(value = "/books/title/{title}", method = RequestMethod.GET)
    Collection<Book> getBooksBySearch(@PathVariable("title") String title);

    //---------------------------------------------------------------------------
    
    //Copy

    @RequestMapping(value = "/copies/book/{id}", method = RequestMethod.GET)
    Collection<Copy> findByBook_Id(@PathVariable int id);


    //---------------------------------------------------------------------------
    
    //Booking

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)
    ResponseEntity<?> createBooking(@RequestParam("userId") int userId, @RequestParam("copyId") int copyId);

    @RequestMapping(value = "/bookings/{id}/extend", method = RequestMethod.PUT)
    Booking extendBooking(@PathVariable("id") int bookingId);

    @RequestMapping(value = "/bookings/user/{id}/status/{status}", method = RequestMethod.GET)
    Collection<Booking> getBookingsByUserAndStatus(@PathVariable("id") int id,@PathVariable("status") String status);

    //---------------------------------------------------------------------------

    //User

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    ResponseEntity<?> createUser(@RequestBody User user);

    @RequestMapping(value = "/users/username/{username}", method = RequestMethod.GET)
    User getUserByUsername(@PathVariable("username") String username);


}
