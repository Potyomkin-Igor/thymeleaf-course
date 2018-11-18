package com.thymeleaf.course.mapper;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User mapUserRequest2User(UserSignUpRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        return user;
    }
}
