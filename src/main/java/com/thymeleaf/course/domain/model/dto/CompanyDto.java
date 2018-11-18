package com.thymeleaf.course.domain.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyDto {

    Long id;
    String name;
    List<EmployeeDto> employees;
}
