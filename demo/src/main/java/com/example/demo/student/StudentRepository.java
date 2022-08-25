package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//types in <> are the type of the object we want to work with and the type of the primary id of that object
//reespository is responsible for data access
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
