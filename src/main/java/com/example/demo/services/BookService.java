package com.example.demo.services;


import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements Ibook {
@Autowired
    BookRepo bookRepo;

    @Override
    public void saveBook(Book bk) {
        bookRepo.save(bk);

    }
    @Override
    public Optional<Book> searchBookByIsb(int Isbn){
        return bookRepo.findByIsbn(Isbn);
        //return null;
    }
    @Override
    public Optional<Book> searchBookByName(String Name){
        return bookRepo.findByBookName(Name);
        //return null;
    }
    @Override
    public List<Author>getAuthorsDeatilsByBookName(String name){
        return bookRepo.authsByBookName(name);

    }

    @Override
    public void deleteBookbyId(long id) {

         bookRepo.deleteById(id);

    }

}
