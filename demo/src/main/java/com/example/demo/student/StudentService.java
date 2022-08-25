package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

//Service layer
@Service
//annotation to allow it to specify its a service class
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        returns a list for us. repository contains methods for everything
        return studentRepository.findAll();
//        return List.of(new Student(1L, "maria", "maria@maria.com", LocalDate.of(2000, Month.JANUARY,  5), 21));
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }
}
