package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// This acts as a Service layer for our API Layer and Service helps us acheive that which is similar to component
@Service
public class StudentService {
	public List<Student> getStudent(){
		return List.of(
			new Student(
				1L, 
				"Prachet",
				"prachetshah@gmail.com",
				21,
				LocalDate.of(2002, 12, 26)
			)
		);
	}

}
