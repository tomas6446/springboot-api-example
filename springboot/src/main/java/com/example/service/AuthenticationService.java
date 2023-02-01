package com.example.service;

import com.example.dto.LoginDto;
import com.example.dto.RegisterDto;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.security.AuthenticationResponse;
import com.example.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Tomas Kozakas
 */

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterDto registerDto) {
        User user = User.builder().name(registerDto.getName()).surname(registerDto.getSurname()).email(registerDto.getEmail()).password(passwordEncoder.encode(registerDto.getPassword())).role(Role.USER).build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
