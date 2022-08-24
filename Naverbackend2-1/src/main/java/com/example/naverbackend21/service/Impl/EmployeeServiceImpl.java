package com.example.naverbackend21.service.Impl;

import com.example.naverbackend21.entity.Employee;
import com.example.naverbackend21.entity.Employee;
import com.example.naverbackend21.repository.EmployeeRepository;
import com.example.naverbackend21.repository.EmployeeRepository;
import com.example.naverbackend21.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee createEmployee(Employee Employee) {
        employeeRepository.save(Employee);
        return Employee;
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employeeRepository.deleteById(id);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
