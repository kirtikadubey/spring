package com.example.demo.repository;

import com.example.demo.dto.BookBorrowed;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    public Optional<Book> findByIsbn(int isbn);
    public Optional<Book> findByBookName(String name);
//    @Query("SELECT *from student ")
//    public BookBorrowed getJoinInformation();
//    @Query("SELECT new com.example.demo.dto.BookAuthors(b.bookName, a.authName) FROM Book b where b.bookName =:name  JOIN b.authors a")
@Query(value = "select * from Student ",nativeQuery = true)
   public List<Author>authsByBookName(String name);




}
