package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{
            Student prachet = new Student(
				"Prachet",
				"prachetshah@gmail.com",
				LocalDate.of(2002, 1, 26)
			);

            Student kevin = new Student(
                2L,
				"Kevin",
				"kevin@gmail.com",
				LocalDate.of(2002, 1, 26)
			);

            repository.saveAll(List.of(prachet, kevin));
        };
    }
}
