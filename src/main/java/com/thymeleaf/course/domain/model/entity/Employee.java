package com.thymeleaf.course.domain.model.entity;

import com.thymeleaf.course.domain.model.dictionary.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
@FieldDefaults(level = AccessLevel.PACKAGE)
public class Employee {

    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;
    String email;

    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    Company company;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "employees_skills",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    Set<Skill> skills;
}
