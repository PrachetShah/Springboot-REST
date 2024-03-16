package com.example.demo.student;

import java.time.LocalDate;

// This is the Student Class where we create student object for our application to use, create constructors,
// getters and setters which are used by controller and service layer to serve outputs
public class Student {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dob;

    public Student(){

    }

    public Student(Long id, String name, String email, Integer age, LocalDate dob){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public Student(String name, String email, Integer age, LocalDate dob){
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Student{"+"id="+id+", name="+name+", email="+email+", age="+age+", dob="+dob+"}";
    }
    
    
}
