package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tomas Kozakas
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
