package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.error.NoBookFoundException;
import com.example.demo.services.Ibook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class BookController {
    @Autowired
    Ibook bookService;
    /*serach book by isbn***/
    @RequestMapping(value = "book/{Isbn}",method= RequestMethod.GET)
    public Book BookDetailsByIsbn(@PathVariable Integer Isbn){
        return bookService.searchBookByIsb(Isbn).get();

    }
    /**serach book by Name***/
    @GetMapping(value = "book/name/{name}")
    public Book bookDetailsByName(@PathVariable(value="name") String name) {

        Optional<Book> book = bookService.searchBookByName(name);
        return book.orElseThrow(NoBookFoundException::new);

    }
    @PostMapping(value = "book")
    public void saveBook(@RequestBody Book bk){
        bookService.saveBook(bk);
    }

    @GetMapping(value= "book/auths")
    public List<Author> getAuthDetails(@RequestParam String name){
        return bookService.getAuthorsDeatilsByBookName(name);
    }

    @DeleteMapping(value ="book/{id}")
    public void deleteBookByName(@PathVariable long id)
    {
         try {
             bookService.deleteBookbyId(id);
        }
         catch(Exception e) {
             throw new NoBookFoundException();
        }
    }
}
