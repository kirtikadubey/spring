package com.example.demo.controller;

import com.example.demo.dto.BookBorrowed;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.services.Ibook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "book",method= RequestMethod.GET)
    public Book bookDetailsByName(@RequestParam(value="name") String name){
        return bookService.searchBookByName(name).get();
    }
    @RequestMapping(value = "book",method= RequestMethod.POST)
    public void saveBook(@RequestBody Book bk){
        bookService.saveBook(bk);
    }

    @RequestMapping(value= "book/auths",method=RequestMethod.GET)
    public List<Author> getAuthDetails(@RequestParam String name){
        return bookService.getAuthorsDeatilsByBookName(name);
    }


}
