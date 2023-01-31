package com.grade.controller;

import com.grade.dto.StudentDto;
import com.grade.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody StudentDto studentDTO) {
        studentService.addStudent(studentDTO);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDTO) {
        studentService.updateStudent(id, studentDTO);
    }
}

