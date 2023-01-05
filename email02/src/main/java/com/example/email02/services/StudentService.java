package com.example.email02.services;

import com.example.email02.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private List<Student> studentList = Arrays.asList(

            new Student("1", "Alessio", "Pacelli", "alessio.alemix41@gmail.com"),
            new Student("2", "Giulia", "Verdi", "giulia.alemix41@gmail.com"),
            new Student("3", "Stefano", "Gialli", "stefano.alemix41@gmail.com"),
            new Student("4", "Mario", "Rossi", "mario.alemix41@gmail.com")
    );

    public Student getStudentById(String studentId){

        Optional<Student> studentFromList = studentList.stream().filter(student -> student.getId() == studentId).findAny();
        if(studentFromList.isPresent()) return studentFromList.get();
        return null;
    }


}
