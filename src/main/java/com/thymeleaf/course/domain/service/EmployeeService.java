package com.thymeleaf.course.domain.service;

import com.thymeleaf.course.domain.model.dto.EmployeeDto;
import com.thymeleaf.course.domain.model.entity.Employee;
import com.thymeleaf.course.domain.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeByCompany(Long companyId) {
        return employeeRepository.getAllByCompanyId(companyId);
    }
}
