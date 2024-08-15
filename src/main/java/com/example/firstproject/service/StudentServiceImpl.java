package com.example.firstproject.service;

import com.example.firstproject.Student;
import com.example.firstproject.repos.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository repo;

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        return repo.findAll();

    }

    @Override
    public Student getStudentById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteStudentById(Integer id) {
        repo.deleteById(id);

    }


}
