package com.grade.service;

import com.grade.model.Student;
import com.grade.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final StudentRepository studentRepository;

    public AuthenticationServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void authenticate(String username, String password) {
        List<Student> studentList = studentRepository.findAll();
        // TODO: validation
    }
}