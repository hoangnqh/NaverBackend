package com.example.naverbackend21.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENT")
@Setter
@Getter
@Component
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
