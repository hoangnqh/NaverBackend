package com.example.demo.service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAll();

    public Department getDepartmentById(Long id);

    public Department create(Department department);

    public Department update(Long id, Department department);

    public String delete(Long id);

    public DepartmentDto getDepartmentWithCountEmployee(Long id);
}
