package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Declares that this interface is responsible for data access
@Repository
// Extends a repository of the student class and the id type is Long
public interface StudentRepository extends JpaRepository<Student, Long>{
}
