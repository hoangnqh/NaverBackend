package com.example.demo.service;

import com.example.demo.dto.EmployeeInfoDto;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();

    public Employee getEmployeeById(Long id);

    public Employee create(Employee employee);

    public Employee update(Long id, Employee employee);

    public String delete(Long id);

    public EmployeeInfoDto getInfoById(Long id);
}
