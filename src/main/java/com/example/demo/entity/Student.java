package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int roll;
    private String name;
    private String className;
    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "st_bks",referencedColumnName = "id")
    private List<Book> books;
}
