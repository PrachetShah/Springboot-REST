package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // requestbody takes in request arguments and maps it to Student
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        String result = studentService.deleteStudent(studentId);
        return result;
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, 
                            @RequestParam(required = false) String name, 
                            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name , email);
    }
}
