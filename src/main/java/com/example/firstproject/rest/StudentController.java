package com.example.firstproject.rest;

import com.example.firstproject.Student;

import com.example.firstproject.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {



    @Autowired
    private StudentServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        System.out.println("Received student: " + student);
        Student savedStudent = service.saveStudent(student); // Save the student using the service
        return  ResponseEntity.ok(savedStudent); // Return the saved student
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return students;

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student stud = service.getStudentById(id);
         return ResponseEntity.ok(stud);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) {
        // Öğrenciyi ID ile silme işlemi burada yapılır
        StudentServiceImpl service = new StudentServiceImpl();
        service.deleteStudentById(id);

        // İşlem başarılı ise HTTP 200 OK durumunu döndürür
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
