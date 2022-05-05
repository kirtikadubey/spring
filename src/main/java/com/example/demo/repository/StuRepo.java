package com.example.demo.repository;

import com.example.demo.dto.BookBorrowed;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StuRepo extends JpaRepository<Student,Long>{

    public Optional<Student> findByName(String name);
    Optional<Student> findByRoll(int roll);
   //@Query("SELECT new com.example.demo.dto.BookBorrowed(s.name, b.bookName) FROM Student s JOIN s.books b")
   //@Query("SELECT new com.example.demo.dto.BookBorrowed(s.name, b.bookName) FROM Book b JOIN b.student s")
//   @Query(value = "select s.name as name,b.book_name as bookName from Student s JOIN Book b on s.id = b.stu_id",nativeQuery = true)
//    public List<BookBorrowed> getJoinInformation();
    @Query(value = "select * from Student s where s.name = :studentName", nativeQuery = true)
    public Student filterByName(String studentName);
    @Query(nativeQuery = true)
    List<BookBorrowed> findByStudent_BookBorrowed();
}
