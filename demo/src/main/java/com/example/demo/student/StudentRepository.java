package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Declares that this interface is responsible for data access
@Repository
// Extends a repository of the student class and the id type is Long
public interface StudentRepository extends JpaRepository<Student, Long> {

    // This will perform an operation on the DB similar to the SQL command: 
    // SELECT * FROM student WHERE email = ? (whatever input we decide)
    // This is going to be used for checking if an email already exists within the DB
    Optional<Student> findStudentByEmail(String email);

    // OR we can also use the following which will accomplish the same thing:
    // @Query("SELECT s FROM Student s WHERE s.email = ?1");
}
