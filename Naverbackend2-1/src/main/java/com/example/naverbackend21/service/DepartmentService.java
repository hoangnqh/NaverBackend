package com.example.naverbackend21.service;

import com.example.naverbackend21.entity.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public List<Department> getAllDepartment();

    public Optional<Department> getDepartmentById(Long id);

    public Department createDepartment(Department department);

    public void updateDepartment(Long id, Department department);

    public void deleteDepartment(Long id);
}
