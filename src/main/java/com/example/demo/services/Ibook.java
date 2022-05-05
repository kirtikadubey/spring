package com.example.demo.services;

import com.example.demo.dto.BookBorrowed;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface Ibook {
    public Optional<Book> searchBookByIsb(int Isbn);
    public Optional<Book> searchBookByName(String name);
    public void saveBook(Book bk);
    public List<Author>getAuthorsDeatilsByBookName(String name);
}
