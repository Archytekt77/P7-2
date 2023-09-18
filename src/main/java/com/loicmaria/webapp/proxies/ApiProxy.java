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
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    Book getBook(@PathVariable("id") int id);

    @RequestMapping(value = "/books/all", method = RequestMethod.GET)
    Collection<Book> getBooks();

    @RequestMapping(value = "/books/{title}", method = RequestMethod.GET)
    Collection<Book> getBooksBySearch(@PathVariable("title") String title);

    //---------------------------------------------------------------------------
    
    //Copy

    /**
     * Read - Get one copy
     *
     * @param id The id of the copy
     * @return An Copy object full filled
     */
    @RequestMapping(value = "/copies/{id}", method = RequestMethod.GET)
    Copy getCopy(@PathVariable("id") int id);

    /**
     * Read - Get all copies
     *
     * @return - An Iterable object of Copy full filled
     */
    @RequestMapping(value = "/copies/all", method = RequestMethod.GET)
    Collection<Copy> getCopies();

    /**
     * Update - Update an existing copy
     *
     * @param id     - The id of the copy to update
     * @param copy - The copy object updated
     * @return The currentCopy if he is present or null
     */
    @RequestMapping(value = "/copies/{id}", method = RequestMethod.PUT)
    Copy updateCopy(@PathVariable("id") int id, @RequestBody Copy copy);


    //---------------------------------------------------------------------------
    
    //Loan

    /**
     * Create - Add a new loan
     *
     * @param loan An object loan
     * @return The loan object saved
     */
    @RequestMapping(value = "/loans/create", method = RequestMethod.POST)
    ResponseEntity<?> createLoan(@RequestBody Loan loan);

    /**
     * Read - Get one loan
     *
     * @param id The id of the loan
     * @return An Loan object full filled
     */
    @RequestMapping(value = "/loans/{id}", method = RequestMethod.GET)
    Loan getLoan(@PathVariable("id") int id);

    /**
     * Read - Get all loans
     *
     * @return - An Iterable object of Loan full filled
     */
    @RequestMapping(value = "/loans/all", method = RequestMethod.GET)
    Collection<Loan> getLoans();

    /**
     * Update - Update an existing loan
     *
     * @param id     - The id of the loan to update
     * @param loan - The loan object updated
     * @return The currentLoan if he is present or null
     */
    @RequestMapping(value = "/loans/{id}", method = RequestMethod.PUT)
    Loan updateLoan(@PathVariable("id") int id, @RequestBody Loan loan);

    /**
     * Delete - Delete an loan
     *
     * @param id - The id of the loan to delete
     */
    @RequestMapping(value = "/loans/{id}", method = RequestMethod.DELETE)
    void deleteLoan(@PathVariable("id") int id);

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
    @RequestMapping(value = "/types/{id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") int id);

    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    Collection<User> getUsers();

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    User updateUser(@PathVariable("id") int id, @RequestBody User user);

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("id") int id);

}
