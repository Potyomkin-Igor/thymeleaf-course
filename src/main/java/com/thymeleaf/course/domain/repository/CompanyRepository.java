package com.thymeleaf.course.domain.repository;

import com.thymeleaf.course.domain.model.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    Company findByName(String name);
}
