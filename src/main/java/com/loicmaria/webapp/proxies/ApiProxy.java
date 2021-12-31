package com.loicmaria.webapp.proxies;

import com.loicmaria.webapp.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "api", url = "localhost:9000")
public interface ApiProxy{

    //JWT

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    ResponseEntity<?> saveUser(@RequestBody User user);

    //---------------------------------------------------------------------------

    //Author

    /**
     * Create - Add a new author
     *
     * @param author An object author
     * @return The author object saved
     */
    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    Author createAuthor(@RequestBody Author author);

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
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    Collection<Author> getAuthors();

    /**
     * Update - Update an existing author
     *
     * @param id     - The id of the author to update
     * @param author - The author object updated
     * @return The currentAuthor if he is present or null
     */
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
    Author updateAuthor(@PathVariable("id") int id, @RequestBody Author author);

    /**
     * Delete - Delete an author
     *
     * @param id - The id of the author to delete
     */
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    void deleteAuthor(@PathVariable("id") int id);

    //---------------------------------------------------------------------------
    
    //Book

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    Book createBook(@RequestBody Book book);

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    Book getBook(@PathVariable("id") int id);

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    Collection<Book> getBooks();

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    Book updateBook(@PathVariable("id") int id, @RequestBody Book book);

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    void deleteBook(@PathVariable("id") int id);

    @RequestMapping(value = "/books/{title}/{language}", method = RequestMethod.GET)
    Collection<Book> getBooksBySearch(@PathVariable("title") String title, @PathVariable("language") String language5555555555555);

    //---------------------------------------------------------------------------
    
    //Copy

    /**
     * Create - Add a new copy
     *
     * @param copy An object copy
     * @return The copy object saved
     */
    @RequestMapping(value = "/copies", method = RequestMethod.POST)
    Copy createCopy(@RequestBody Copy copy);

    /**
     * Read - Get one copy
     *
     * @param id The id of the copy
     * @return An Copy object full filled
     */
    @RequestMapping(value = "/copies/{id}", method = RequestMethod.GET)
    Copy getCopy(@PathVariable("id") int id);

    /**
     * Read - Get all authors
     *
     * @return - An Iterable object of Copy full filled
     */
    @RequestMapping(value = "/copies", method = RequestMethod.GET)
    Collection<Copy> getCopys();

    /**
     * Update - Update an existing copy
     *
     * @param id     - The id of the copy to update
     * @param copy - The copy object updated
     * @return The currentCopy if he is present or null
     */
    @RequestMapping(value = "/copies/{id}", method = RequestMethod.PUT)
    Copy updateCopy(@PathVariable("id") int id, @RequestBody Copy copy);

    /**
     * Delete - Delete an copy
     *
     * @param id - The id of the copy to delete
     */
    @RequestMapping(value = "/copies/{id}", method = RequestMethod.DELETE)
    void deleteCopy(@PathVariable("id") int id);

    //---------------------------------------------------------------------------
    
    //Loan

    /**
     * Create - Add a new loan
     *
     * @param loan An object loan
     * @return The loan object saved
     */
    @RequestMapping(value = "/loans", method = RequestMethod.POST)
    Loan createLoan(@RequestBody Loan loan);

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
    @RequestMapping(value = "/loans", method = RequestMethod.GET)
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
     * Create - Add a new type
     *
     * @param type An object type
     * @return The type object saved
     */
    @RequestMapping(value = "/types", method = RequestMethod.POST)
    Type createType(@RequestBody Type type);

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
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    Collection<Type> getTypes();

    /**
     * Update - Update an existing type
     *
     * @param id     - The id of the type to update
     * @param type - The type object updated
     * @return The currentType if he is present or null
     */
    @RequestMapping(value = "/types/{id}", method = RequestMethod.PUT)
    Type updateType(@PathVariable("id") int id, @RequestBody Type type);

    /**
     * Delete - Delete an type
     *
     * @param id - The id of the type to delete
     */
    @RequestMapping(value = "/types/{id}", method = RequestMethod.DELETE)
    void deleteType(@PathVariable("id") int id);

    //---------------------------------------------------------------------------

    //User

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    User createUser(@RequestBody User user);

    /**
     * Read - Get one user
     *
     * @param id The id of the user
     * @return An User object full filled
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") int id);

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    Collection<User> getUsers();

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    User updateUser(@PathVariable("id") int id, @RequestBody User user);

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable("id") int id);


}
