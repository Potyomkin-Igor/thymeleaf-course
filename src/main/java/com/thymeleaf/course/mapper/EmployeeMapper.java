package com.thymeleaf.course.mapper;

import com.thymeleaf.course.domain.model.entity.Employee;
import com.thymeleaf.course.domain.model.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public static EmployeeDto mapEmployee2EmployeeDto (Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setGender(employee.getGender());

        return employeeDto;
    }
}
