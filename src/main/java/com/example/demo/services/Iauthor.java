package com.example.demo.services;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Student;

import java.util.List;
import java.util.Optional;


public interface Iauthor {
    public Optional<Author> authorByAuthorId(long id);
    public void saveAuthor(Author auth);
}
