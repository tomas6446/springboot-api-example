package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tomas Kozakas
 */
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDto userDTO) {
        userService.addStudent(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteStudent(id);
    }

    @GetMapping("/user")
    public List<UserDto> getAllUsers() {
        return userService.getAllStudents();
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDTO) {
        userService.updateStudent(id, userDTO);
    }
}

