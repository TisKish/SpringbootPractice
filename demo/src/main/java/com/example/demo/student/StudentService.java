package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This service is considered apart of the Service layer; It gives data back to the API layer 

// This annotation declares that this is a service bean
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        // This will return all results from our DB based on specifications in our studentRepository
        return studentRepository.findAll();

        // --- Commented out in favor of using the studentRepository in order to find results from our DB ---
		// return List.of(new Student(
		// 	1L,
		// 	"Harry",
		// 	"harry.potter@gmail.com",
		// 	LocalDate.of(2000, Month.JANUARY, 5),
		// 	21
        //     )
        // );
        // ---------------------------------------------------------

	}
}
