package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}