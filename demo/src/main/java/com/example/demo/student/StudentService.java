package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        // If that certain email is already present in the DB, then throw the exception with message: "email taken"
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        // Saves the student into the DB as long as the above exception did not occur
        studentRepository.save(student);

        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        // This checks to see if the studentId currently exists in the DB
        boolean exists = studentRepository.existsById(studentId);
        // If it doesn't exist, then throw an exception
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        // Otherwise, delete the student with that id
        studentRepository.deleteById(studentId);
    }

        // This annotation makes it so that we don't have to use any queries from the StudentRepository. The entity goes into a managed state 
        @Transactional
        // This checks if the student exists in the DB, if not, then throw an exception
        public void updateStudent(Long studentId, String name, String email) {
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist" ));

        // If the entered name is not null and has at least one letter and is not the same as their current name, then set their name to be the entered name
        if (name != null && name.length() > 0 &&
        !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        // If the entered email is not null and has at least one letter and is not the same as their current email, then check if the entered email already exists in the DB
        // If not, then set their email to be the entered email
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
    
}
