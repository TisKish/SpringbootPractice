package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

// This annotation is for hibernate
@Entity
// This annotation declares a table to be created in our DB; It maps our class to a table in our DB
@Table
// An example of a class that defines a Student with their corresponding metadata
public class Student {
    // Creates the id with a generated sequence of numbers
    @Id
    @SequenceGenerator(
        name = "student_sequence", 
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    // This annotation declares that there is no need for age to be a column in our DB. Age can still be calculated and called on though
    @Transient
    private Integer age;

    // ===== Constructors =====
    // This is a null constructor 
    public Student () {
    }

    // This is a constructor with everything 
    public Student(Long id, 
    String name, 
    String email,
    LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // This is a constructor without id
    public Student(String name, 
    String email,
    LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    // ===============================

    // ===== Getters and Setters =====

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getDob(){
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    public Integer getAge(){
        // This will calculate the age for us based on their dob and what the date is now. This is good since age will not remain static
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    // ==========================================

    // Complete toString override
    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", name = '" + name + "/'" +
        ", email = '" + email + "/'" +
        ", dob = " + dob +
        ", age = " + age +
        "}";

    }

}
