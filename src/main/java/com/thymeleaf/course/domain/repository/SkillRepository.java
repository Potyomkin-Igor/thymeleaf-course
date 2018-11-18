package com.thymeleaf.course.domain.repository;

import com.thymeleaf.course.domain.model.entity.Skill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {
}
