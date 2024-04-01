package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public String deleteStudent(Long studentId){
		boolean exists = studentRepository.existsById(studentId);
		if(!exists){
			throw new IllegalStateException("No Student with Id: "+studentId+ " does not Exists");
		}
		studentRepository.deleteById(studentId);
		return "Student with Id: " + studentId + " deleted";
	}

	// because of this @Transactional annotation, meaning that any database operations performed within the marked method or 
	// class will be executed within a transaction. If the transaction is successful, the changes will be committed to the database.
	// we can directly use getters and setters to make changes, as it goes into manage state and there is no need to use repository/DB cmds
	@Transactional
	public void updateStudent(Long studentId, String name, String email){
		Student student = studentRepository.findById(studentId).orElseThrow(()-> 
			new IllegalStateException("No Student with Id: "+studentId+ " does not Exists")
		);
		
		if(name != null && name.length()>0 && !Objects.equals(student.getName(), name)){
			student.setName(name);
		}

		if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
			// check here for passed email to check whether email exists in DB or not
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if(studentOptional.isPresent()){
				throw new IllegalStateException("Email Taken");
			}
			student.setEmail(email);
		}
	}

}
