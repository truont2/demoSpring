package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//have all the resources for the api to get student information
//api layer talks to service layer and accesses data layer to retrieve data
@RestController
//path is after 8080
@RequestMapping(path = "api/v1/student")
public class StudentController {
    //	declare as a get endpoint

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
