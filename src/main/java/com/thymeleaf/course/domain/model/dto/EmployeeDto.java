package com.thymeleaf.course.domain.model.dto;

import com.thymeleaf.course.domain.model.dictionary.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    String firstName;
    String lastName;
    String email;
    Gender gender;

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }

    public boolean isMan() {
        return Gender.MALE.equals(gender);
    }

    @Override
    public String toString() {
        return firstName
                .concat(" ")
                .concat(lastName)
                .concat(" ")
                .concat(gender.toString());
    }
}
