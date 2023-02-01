package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tomas Kozakas
 */
@RestController
@RequestMapping("/api/v1/demo")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDto userDTO) {
        userService.addUser(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDTO) throws Exception {
        userService.updateUsers(id, userDTO);
    }
}

