package com.example.repository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * @author Tomas Kozakas
 */
@Repository
public class UserDao {
    public final static List<UserDetails> APPLICATION_USERS = Collections.singletonList(
            new User("tomas.kozakas@gmail.com", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")))
    );

    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }
}
