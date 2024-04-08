package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

// This is the Student Class where we create student object for our application to use, create constructors,
// getters and setters which are used by controller and service layer to serve outputs

// For Hibernate
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name="student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    // No need to be a column in database, it should be calculated from DOB
    // we use the @Transient annotation to indicate the Java Persistence API (JPA) should ignore the 
    // field when mapping objects to a database.
    @Transient
    private Integer age;

    public Student(){

    }

    public Student(Long id, String name, String email, LocalDate dob){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob){
        this.name = name;
        this.email = email;
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
        return Period.between(this.dob, LocalDate.now()).getYears();
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

    // The @Override annotation denotes that the child class method overrides the base class method. 
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Student{"+"id="+id+", name="+name+", email="+email+", age="+age+", dob="+dob+"}";
    }
    
    
}
