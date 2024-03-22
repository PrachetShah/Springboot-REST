package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This component is essential for data access -> Data Access layer which is used to access and modify the DB
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    // SELECT * from student where email=email -. this is done by Optional in Java which writes SQL based on the function name
    // @Query("Select s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);
}
