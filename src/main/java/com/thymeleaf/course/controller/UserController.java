package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dto.UserSignUpRequest;
import com.thymeleaf.course.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping(value = "/signup")
    public ModelAndView getSignUpPage(ModelAndView model) {
        model.setViewName("signUp");
        model.addObject("userSignUpRequest", new UserSignUpRequest());
        return model;
    }

    @PostMapping(value = "/signup")
    public ModelAndView saveUser(@Valid @ModelAttribute UserSignUpRequest userSignUpRequest,
                                 BindingResult bindingResult,
                                 ModelAndView model) {
        if (bindingResult.hasErrors()) {
            model.setViewName("signUp");
            bindingResult.addError(validatePassword(userSignUpRequest));
            return model;
        }
        userService.saveUser(userSignUpRequest);
        model.setViewName("index");
        return model;
    }

    private ObjectError validatePassword(UserSignUpRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return new ObjectError("UserSignUpRequest", "Confirm password doesn't match");
        }
        return null;
    }
}
