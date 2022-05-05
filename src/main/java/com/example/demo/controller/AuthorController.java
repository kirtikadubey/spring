package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepo;
import com.example.demo.services.AuthorService;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping(value="auth/{id}",method=RequestMethod.GET)
    public Optional<Author> authorDetails(@PathVariable long id){
       return authorService.authorByAuthorId(id);

    }
    @RequestMapping(value= "auth/set",method= RequestMethod.POST)
    public void setAuthorDetails(@RequestBody Author auth){
         authorService.saveAuthor(auth);
    }

}
