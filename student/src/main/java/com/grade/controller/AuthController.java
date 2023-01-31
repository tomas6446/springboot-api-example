package com.grade.controller;

import com.grade.dto.LoginDto;
import com.grade.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto) {
        authenticationService.authenticate(loginDto.getUsername(), loginDto.getPassword());
    }
}