package com.example.demo.services;

import com.example.demo.dto.BookBorrowed;
import com.example.demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudent {

    public Optional searchStudentByName(String name);
    public Optional searchStudentByRoll(int roll);
    public void saveStudent(Student stu);
    public List<BookBorrowed> joinInfo();

    Student filter(String name);
}
