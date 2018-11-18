package com.thymeleaf.course.domain.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSignUpRequest {

    @NotBlank
    @Size(min = 3, max = 15, message = "Invalid first name")
    String firstName;

    @NotBlank
    @Size(min = 5, max = 25, message = "Invalid last name")
    String lastName;

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Size(max = 50, min = 8, message = "Invalid password")
    String password;

    @NotBlank
    String confirmPassword;

}
