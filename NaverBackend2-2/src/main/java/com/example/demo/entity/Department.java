package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Department {
    @Id
    @GeneratedValue
    @Column(name="departmentId")
    private Long id;

    @Column(name="dept_name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
