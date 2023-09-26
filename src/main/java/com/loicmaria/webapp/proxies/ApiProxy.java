package com.loicmaria.webapp.proxies;

import com.loicmaria.webapp.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "api", url = "localhost:9000")
public interface ApiProxy{

    //Author

    /**
     * Read - Get one author
     *
     * @param id The id of the author
     * @return An Author object full filled
     */
    @RequestMapping(value = "/authors/id/{id}", method = RequestMethod.GET)
    Author getAuthor(@PathVariable("id") int id);

    /**
     * Read - Get all authors
     *
     * @return - An Iterable object of Author full filled
     */
    @RequestMapping(value = "/authors/all", method = RequestMethod.GET)
    Collection<Author> getAuthors();

    //---------------------------------------------------------------------------
    
    //Book

    @RequestMapping(value = "/books/id/{id}", method = RequestMethod.GET)
    Book getBook(@RequestParam("id") int id);

    @RequestMapping(value = "/books/all", method = RequestMethod.GET)
    Collection<Book> getBooks();

    @RequestMapping(value = "/books/title/{title}", method = RequestMethod.GET)
    Collection<Book> getBooksBySearch(@PathVariable("title") String title);

    //---------------------------------------------------------------------------
    
    //Copy

    /**
     * Read - Get one copy
     *
     * @param id The id of the copy
     * @return An Copy object full filled
     */
    @RequestMapping(value = "/copies/id/{id}", method = RequestMethod.GET)
    Copy getCopy(@PathVariable("id") int id);

    /**
     * Update - Update an existing copy
     *
     * @param id     - The id of the copy to update
     * @param copy - The copy object updated
     * @return The currentCopy if he is present or null
     */
    @RequestMapping(value = "/copies/id/{id}", method = RequestMethod.PUT)
    Copy updateCopy(@PathVariable("id") int id, @RequestBody Copy copy);

    @RequestMapping(value = "/copies/book_id/{id}", method = RequestMethod.GET)
    Collection<Copy> findByBook_Id(@PathVariable int id);


    //---------------------------------------------------------------------------
    
    //Booking

    /**
     * Create - Add a new booking
     *
     * @param booking An object booking
     * @return The booking object saved
     */
    @RequestMapping(value = "/bookings/create", method = RequestMethod.POST)
    ResponseEntity<?> createBooking(@RequestBody Booking booking);

    /**
     * Read - Get one booking
     *
     * @param id The id of the booking
     * @return An Booking object full filled
     */
    @RequestMapping(value = "/bookings/id/{id}", method = RequestMethod.GET)
    Booking getBooking(@PathVariable("id") int id);

    /**
     * Read - Get all bookings
     *
     * @return - An Iterable object of Booking full filled
     */
    @RequestMapping(value = "/bookings/all", method = RequestMethod.GET)
    Collection<Booking> getBookings();

    /**
     * Update - Update an existing booking
     *
     * @param id     - The id of the booking to update
     * @param booking - The booking object updated
     * @return The currentBooking if he is present or null
     */
    @RequestMapping(value = "/bookings/id/{id}", method = RequestMethod.PUT)
    Booking updateBooking(@PathVariable("id") int id, @RequestBody Booking booking);

    /**
     * Delete - Delete an booking
     *
     * @param id - The id of the booking to delete
     */
    @RequestMapping(value = "/bookings/id/{id}", method = RequestMethod.DELETE)
    void deleteBooking(@PathVariable("id") int id);

    //---------------------------------------------------------------------------

    //Role

    //---------------------------------------------------------------------------

    //Type

    /**
     * Read - Get one type
     *
     * @param id The id of the type
     * @return An Type object full filled
     */
    @RequestMapping(value = "/types/id/{id}", method = RequestMethod.GET)
    Type getType(@PathVariable("id") int id);

    /**
     * Read - Get all types
     *
     * @return - An Iterable object of Type full filled
     */
    @RequestMapping(value = "/types/all", method = RequestMethod.GET)
    Collection<Type> getTypes();

    //---------------------------------------------------------------------------

    //User

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    ResponseEntity<?> createUser(@RequestBody User user);

    /**
     * Read - Get one user
     *
     * @param id The id of the user
     * @return An User object full filled
     */
    @RequestMapping(value = "/users/id/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") int id);

    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    Collection<User> getUsers();

    @RequestMapping(value = "/users/id/{id}", method = RequestMethod.PUT)
    User updateUser(@PathVariable("id") int id, @RequestBody User user);

    @RequestMapping(value = "/users/id/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("id") int id);

    @RequestMapping(value = "/users/username/{username}", method = RequestMethod.GET)
    User getUserByUsername(@PathVariable("username") String username);


}
