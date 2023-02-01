package com.example.service;

import com.example.dto.UserDto;
import com.example.exception.ResourceNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tomas Kozakas
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addStudent(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        userRepository.save(user);
    }

    public void deleteStudent(Long studentId) {
        if (userRepository.existsById(studentId)) {
            userRepository.deleteById(studentId);
        }
    }

    public List<UserDto> getAllStudents() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getName(), user.getSurname()))
                .collect(Collectors.toList());
    }

    public void updateStudent(Long id, UserDto userDTO) {
        userRepository.findById(id)
                .map(s -> {
                    s.setName(userDTO.getName());
                    s.setSurname(userDTO.getSurname());
                    return userRepository.save(s);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
    }
}