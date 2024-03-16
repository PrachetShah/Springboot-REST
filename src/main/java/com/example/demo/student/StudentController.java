package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This is controller class and RestController is needed to send responses to Service Layer and create paths
@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;

    /*
    Constructor
    Autowired heps solve the dependency injection problem, this means that 
    above declared studentService is injected to this constructor

    Autowired finds for the "BEAN" which is declared using @Service in studentMapping to prevent dependency injection
    */ 
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudent();
    }
}
