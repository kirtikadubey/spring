package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String authName;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name= "author_id")
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "author_book",
            joinColumns=@JoinColumn(name= "book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    List<Book> books;
}
