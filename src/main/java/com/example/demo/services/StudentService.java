package com.example.demo.services;

import com.example.demo.dto.BookBorrowed;
import com.example.demo.entity.Student;
import com.example.demo.repository.StuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService implements IStudent {

    @Autowired
    StuRepo stuRepo;

    public Optional searchStudentByRoll(int roll){
        return stuRepo.findByRoll(roll);
        //return null;
    }
    public Optional searchStudentByName(String name){
        return stuRepo.findByName(name);
        //return null;
    }
    public void saveStudent(Student stu){
        stuRepo.save(stu);

    }
    @Override
    public List<BookBorrowed> joinInfo(){
        return stuRepo.findByStudent_BookBorrowed();
    }

    @Override
    public Student filter(String name) {
        return stuRepo.filterByName(name);
    }


}
