package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    BookService bookService;
    @PostMapping(value ="/book")
    public void createNewBookEntry(@RequestBody Book bk){
        bookService.saveBook(bk);
    }

    @DeleteMapping(value = "/book/{id}")
    public void deleteBook(@PathVariable long id ){
        bookService.deleteBookbyId(id);
    }
}
