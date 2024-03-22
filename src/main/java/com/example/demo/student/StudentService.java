package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
This acts as a Service layer for our API Layer and Service helps us acheive that which is similar to component
In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called "beans"
@Service declares that the given class is a bean of our application
*/ 

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	// creating constructor with dependency injection
	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}


	public List<Student> getStudent(){
		// you can call all the DB commands like find_all, find_one, save, etc in this
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student){
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		// checking if returned true by the sql command
		if(studentOptional.isPresent()){
			throw new IllegalStateException("Email Taken");
		}
		studentRepository.save(student);
	}

}
