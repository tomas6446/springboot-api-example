package com.grade.service;

import com.grade.dto.StudentDto;
import com.grade.exception.ResourceNotFoundException;
import com.grade.model.Student;
import com.grade.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(StudentDto studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        }
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDto(student.getName(), student.getSurname()))
                .collect(Collectors.toList());
    }

    public void updateStudent(Long id, StudentDto studentDTO) {
        studentRepository.findById(id)
                .map(s -> {
                    s.setName(studentDTO.getName());
                    s.setSurname(studentDTO.getSurname());
                    return studentRepository.save(s);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
    }
}