package com.thymeleaf.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("stringParam", "First String Param Example");
        model.addAttribute("integerParam", Integer.MAX_VALUE);
        return "index";
    }
}
