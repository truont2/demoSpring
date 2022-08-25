package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//types in <> are the type of the object we want to work with and the type of the primary id of that object
//reespository is responsible for data access
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    create a custom function that finds a user by email
//    transofrms to a sql to SELECT * from student where email = ?. Dont need query if you want
    @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
