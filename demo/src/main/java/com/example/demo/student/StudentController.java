package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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


    @PostMapping
//    take request body and get student information
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

//    use annotation to specify type of request
//    path variable to get information from the url
    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false)String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
