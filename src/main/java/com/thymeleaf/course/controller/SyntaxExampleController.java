package com.thymeleaf.course.controller;

import com.thymeleaf.course.domain.model.dictionary.Gender;
import com.thymeleaf.course.domain.model.dto.EmployeeDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SyntaxExampleController {
    static final String INDEX_PAGE = "syntaxExample";
    static final String SYNTAX_EXAMPLE_LINK = "/syntax/example";

    @GetMapping(value = "/syntax/example")
    public String getSyntaxExamplePage(Model model) {
        model.addAttribute("companiesUrl", "/api/companies");
        model.addAttribute("defaultName", "Peter Parker");
        model.addAttribute("greetings", "Hello World");
        model.addAttribute("employee", getTestEmployee());
        model.addAttribute("employeeMap", getMapWithEmployees());
        model.addAttribute("employeeList", getListOfEmployees());
        model.addAttribute("employeeObject", getTestEmployee());
        return INDEX_PAGE;
    }

    @GetMapping(value = "/syntax/example/link-expression")
    public ModelAndView linkExpressionMethod(@ModelAttribute String status, ModelAndView model) {
        model.setView(new RedirectView(SYNTAX_EXAMPLE_LINK));
        return model;
    }

    @GetMapping(value = "/syntax/example/context-relative")
    public ModelAndView contextRelativeExample(ModelAndView model) {
        model.setView(new RedirectView(SYNTAX_EXAMPLE_LINK));
        return model;
    }

    @GetMapping(value = "/syntax/example/inlining")
    public String getInliningExamplePage(Model model) {
        model.addAttribute("defaultName", "Peter Parker");
        model.addAttribute("inlineMessage", "Hello <b>World</b>");
        model.addAttribute("appleJuiceName", "Apple Juice");
        model.addAttribute("classname", "main elems");
        model.addAttribute("align", "center");
        return "inliningExample";
    }


    private EmployeeDto getTestEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setLastName("Parker");
        employeeDto.setFirstName("Peter");
        employeeDto.setEmail("peterParker@mail.com");
        employeeDto.setGender(Gender.MALE);
        return employeeDto;
    }

    private Map<String, EmployeeDto> getMapWithEmployees() {
        Map<String, EmployeeDto> employeeMap = new HashMap<>();
        employeeMap.put("Peter", getTestEmployee());

        return employeeMap;
    }

    private List<EmployeeDto> getListOfEmployees() {
        EmployeeDto first = getTestEmployee();
        EmployeeDto second = getTestEmployee();
        second.setFirstName("Jon");
        second.setLastName("Malkovich");
        second.setEmail("malkovich@mail.com");
        second.setGender(Gender.MALE);

        EmployeeDto third = getTestEmployee();
        third.setFirstName("Kety");
        third.setLastName("Mitchel");
        third.setEmail("kety@mail.com");
        third.setGender(Gender.FEMALE);

        return Arrays.asList(
                first, second, third
        );
    }
}
