package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// This annotation makes the following class serve rest endpoints
// @RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// An example of an annotation 
	// Get mapping because we want to 'get' something out of our server 
	// @GetMapping
	// public String hello() {
	// 	return "Hello world";
	// }

	// The same example but returning a list instead of a string
	// @GetMapping
	// public List<String> helloList() {
	// 	return List.of("Hello", "world");
	// }

	// This creates a list off of students based on our student.java class --> Moved to StudentController
	// @GetMapping
	// public List<Student> helloStudents() {
	// 	return List.of(new Student(
	// 		1L,
	// 		"Harry",
	// 		"harry.potter@gmail.com",
	// 		LocalDate.of(2000, Month.JANUARY, 5),
	// 		21
	// 	));
	// }
}
