package com.thymeleaf.course.mapper;

import com.thymeleaf.course.domain.model.entity.Company;
import com.thymeleaf.course.domain.model.dto.CompanyDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public static CompanyDto mapCompany2CompanyDto(Company company) {
       return CompanyDto.builder()
               .id(company.getId())
               .name(company.getName())
               .build();
    }
}
