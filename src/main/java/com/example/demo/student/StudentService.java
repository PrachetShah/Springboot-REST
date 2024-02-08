package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

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
