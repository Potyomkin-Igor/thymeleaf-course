package com.thymeleaf.course.domain.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "skills")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skill {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @ManyToMany
    Set<Employee> employees;
}
