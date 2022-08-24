package com.example.naverbackend21.service.Impl;

import com.example.naverbackend21.entity.Department;
import com.example.naverbackend21.repository.DepartmentRepository;
import com.example.naverbackend21.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department createDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        departmentRepository.deleteById(id);
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
