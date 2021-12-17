package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// This controller is considered apart of the API layer 
@RestController
// This annotation designates a custom path after localhost:8080
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    // This annotation declares that StudentService should be autowired for us, so studentService should be instantiated(has to be a spring bean; component) for us and injected into the constructor
    @Autowired
    // This is the constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @GetMapping
	public List<Student> getStudents() {
        return studentService.getStudents();
	}

    @PostMapping
    // This RequestBody is taking from a user input and mapping that result into Student. Then addNewStudent will add that to the DB
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // ----- An example POST payload on insomnia could look like: -----
    // POST http://localhost:8080/api/v1/student
    // Content-Type: application/json

    // {
    //     "name": "Hermoine",
    //     "email": "hermoine.granger@gmail.com",
    //     "dob": "2000-3-23"
    // }
    // ---------------------------------------------------------------------

    // This will allow deletion by studentId
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    // ----- An example DELETE payload on insomnia could look like: -----
    // DELETE http://localhost:8080/api/v1/student/1


    // This will delete the student with id 1 
    // That is why we used the pathVariable annotation
    // ---------------------------------------------------------------------

    // This will allow us to update a student's name or email by searching their id
    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        // name and email are optional fields in this case
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email) {
            studentService.updateStudent(studentId, name, email);
        }

}