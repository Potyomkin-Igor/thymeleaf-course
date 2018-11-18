package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping(value = "/api/companies")
    public ModelAndView getAllCompanies(ModelAndView model) {
        model.setViewName("company");
        model.addObject("companies", companyService.getAllCompanies());

        return model;
    }
}
