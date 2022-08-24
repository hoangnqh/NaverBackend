package com.example.naverbackend21.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date birthDay;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
