package com.example.naverbackend21.service;

import com.example.naverbackend21.entity.Employee;
import com.example.naverbackend21.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Optional<Employee> getEmployeeById(Long id);

    public Employee createEmployee(Employee Employee);

    public void updateEmployee(Long id, Employee employee);

    public void deleteEmployee(Long id);
}
