package com.thymeleaf.course.domain.service;

import com.google.common.collect.Lists;
import com.thymeleaf.course.domain.model.dto.EmployeeDto;
import com.thymeleaf.course.domain.model.entity.Company;
import com.thymeleaf.course.domain.model.dto.CompanyDto;
import com.thymeleaf.course.domain.repository.CompanyRepository;
import com.thymeleaf.course.mapper.CompanyMapper;
import com.thymeleaf.course.mapper.EmployeeMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyService {

    private final CompanyRepository repository;
    private final EmployeeService employeeService;

    @Transactional(readOnly = true)
    public List<Company> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Transactional(readOnly = true)
    public List<CompanyDto> getAllCompanies() {
        List<CompanyDto> companies = getAll().stream()
                .map(CompanyMapper::mapCompany2CompanyDto)
                .collect(Collectors.toList());

        companies.forEach(company -> {
            List<EmployeeDto> employees = employeeService.getAllEmployeeByCompany(company.getId())
                    .stream()
                    .map(EmployeeMapper::mapEmployee2EmployeeDto)
                    .collect(Collectors.toList());

            company.setEmployees(employees);
        });

        return companies;
    }
}
