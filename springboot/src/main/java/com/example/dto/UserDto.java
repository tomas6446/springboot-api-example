package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Tomas Kozakas
 */
@Data
@AllArgsConstructor
public class UserDto {
    private String name;
    private String surname;
}
