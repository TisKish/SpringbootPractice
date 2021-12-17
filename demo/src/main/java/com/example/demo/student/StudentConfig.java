package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student harry = new Student(
			1L,
			"Harry",
			"harry.potter@gmail.com",
			LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student ron = new Student(
			// Id is omitted here because it will be auto generated for us
			"Ron",
			"ron.weasley@gmail.com",
			LocalDate.of(2001, Month.JANUARY, 5)
            );

            // This will save the above into our DB as it loads up
            repository.saveAll(List.of(harry, ron));
        };
    }
}
