package com.example.demo.entity;

import com.example.demo.dto.BookBorrowed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedNativeQuery(name = "Student.findByStudent_BookBorrowed",
        query = "SELECT s.name as name,b.book_name as bookName FROM Student s JOIN Book b on s.id = b.stu_id",
        resultSetMapping = "Mapping.BookBorrowed")
@SqlResultSetMapping(name = "Mapping.BookBorrowed",
        classes = @ConstructorResult(targetClass = BookBorrowed.class,
                columns = {@ColumnResult(name = "name"),
                        @ColumnResult(name = "bookName")}))
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int roll;
    private String name;
    private String className;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> books;

    public void setBooks(List<Book> books){
        this.books = books;
        for(Book book: books){
            book.setStudent(this);
        }
    }

}
