package com.example.demo.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
    private Integer age;

    // ===== Constructors =====
    // This is a null constructor 
    public Student () {
    }

    // This is a constructor with everything 
    public Student(Long id, 
    String name, 
    String email,
    LocalDate dob,
    Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    // This is a constructor without id
    public Student(String name, 
    String email,
    LocalDate dob,
    Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
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
        return age;
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
