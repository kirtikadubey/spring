package com.example.demo.entity;

import com.example.demo.dto.BookBorrowed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//
//@NamedNativeQuery(name = "Book.findBookStudentDto_Borrowed",
//        query = "SELECT s.name as name,b.book_name as bookName FROM Book b JOIN Book b on b.id = b.stu_id",
//        resultSetMapping = "Mapping.BookBorrowed")
//@SqlResultSetMapping(name = "Mapping.BookBorrowed",
//        classes = @ConstructorResult(targetClass = BookBorrowed.class,
//                columns = {@ColumnResult(name = "name"),
//                        @ColumnResult(name = "bookName")}))
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int isbn;
    private String bookName;
    private String available;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "stu_id")//, referencedColumnName = "id")
    private Student student;
    @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
    List<Author> authors;

    public String toString() {
        return "Book(id=" + this.getId() +
                ", isbn=" + this.getIsbn() + ", bookName=" + this.getBookName() +
                ", available=" + this.getAvailable() + ", student=" + this.getStudent().getId() + ")";
    }

}
