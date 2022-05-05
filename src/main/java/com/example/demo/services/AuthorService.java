package com.example.demo.services;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements Iauthor{
    @Autowired
    AuthorRepo authorRepo;
    @Override
    public Optional<Author> authorByAuthorId(long id){

        return authorRepo.findById(id);
    }
    @Override
    public void saveAuthor(Author auth){
        authorRepo.save(auth);
    }
}
