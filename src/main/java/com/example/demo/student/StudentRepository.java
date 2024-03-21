package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This component is essential for data access -> Data Access layer
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
