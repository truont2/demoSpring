package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student does not exist"));
//        Update name
        if((name != null) && (name.length() > 0) && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

//        update the email
        if((email != null) && (email.length() > 0) && (!Objects.equals(student.getEmail(), email))){
//            check if the email hasnt been taken
            Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
            if(studentOptional.isPresent()){
                throw new IllegalStateException("student with email exists already");
            }
            student.setEmail(email);
        }

    }
}
