package com.loicmaria.webapp.proxies;

import com.loicmaria.webapp.model.Book;
import com.loicmaria.webapp.model.JwtRequest;
import com.loicmaria.webapp.model.JwtResponse;
import com.loicmaria.webapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api", url = "localhost:9000")
public interface ApiProxy {

    //JWT

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    ResponseEntity<?> saveUser(@RequestBody User user);


    //Books

    /*@RequestMapping(value = "/books", method = RequestMethod.POST)
    Book createBook(@RequestBody Book book);*/

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    Book getBook(@PathVariable("id") int id);

    /*@RequestMapping(value = "/books", method = RequestMethod.GET)
    Collection<Book> getBooks();

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PATCH)
    Book updateBook(@PathVariable("id") int id, @RequestBody Book book);

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    void deleteBook(@PathVariable("id") int id);*/

}
