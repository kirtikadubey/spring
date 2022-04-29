package com.example.demo.controller;

import com.example.demo.dto.BookBorrowed;
import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.services.IStudent;
import com.example.demo.services.Ibook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class StuController {
    @Autowired
    IStudent studentService;

    @RequestMapping(value = "stu",method = RequestMethod.POST)
    public  void saveStuDetails(@RequestBody Student stu){
        studentService.saveStudent(stu);
    }

    @RequestMapping(value = "stu",method = RequestMethod.GET)
    public  Student StuDetailsByName(@RequestParam String name){
        Optional<Student> opt = studentService.searchStudentByName(name);
        return  opt.get();
    }

    @RequestMapping(value ="stu/{roll}",method = RequestMethod.GET)
    public Student stuDetailsBYRoll(@PathVariable int roll){
        Optional<Student> opt= studentService.searchStudentByRoll(roll);
        return opt.get();
    }
        @RequestMapping(value ="stu/books",method = RequestMethod.GET)
    public List<BookBorrowed> joinDetails(){
        return studentService.joinInfo();
    }

    @GetMapping("stu/filter/{name}")
    public Student filter(@PathVariable String name){

        return studentService.filter(name);
    }
}
