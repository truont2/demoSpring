package com.example.demo.student;
//file to save student to the database

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student maria = new Student( "maria", "maria@maria.com", LocalDate.of(2000, Month.JANUARY,  5), 21);
            Student alex = new Student( "alex", "alex@alex.com", LocalDate.of(2001, Month.JUNE,  5), 21);
            Student megan = new Student( "megan", "megan@megan.com", LocalDate.of(2000, Month.JANUARY,  5), 21);
            Student jennifer = new Student( "jennifer", "jennifer@jennifer.com", LocalDate.of(2000, Month.JANUARY,  5), 21);

//            how you save everything
            studentRepository.saveAll(List.of(maria, alex, megan, jennifer));

        };
    }
}
