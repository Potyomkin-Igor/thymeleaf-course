package com.thymeleaf.course.domain.repository;

import com.thymeleaf.course.domain.model.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> getAllByCompanyId(Long companyId);
}
