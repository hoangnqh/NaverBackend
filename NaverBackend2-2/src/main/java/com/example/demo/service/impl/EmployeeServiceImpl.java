package com.example.demo.service.impl;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeInfoDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.Query.DepartmentRepositoryQuery;
import com.example.demo.repository.Query.EmployeeRepositoryQuery;
import com.example.demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Resource
    EmployeeRepositoryQuery employeeRepositoryQuery;

    @Autowired
    DepartmentRepository departmentRepository;

    @Resource
    DepartmentRepositoryQuery departmentRepositoryQuery;

    ModelMapper modelMapper;
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee;
    }

    @Override
    public Employee create(Employee Employee) {
        employeeRepository.save(Employee);
        return Employee;
    }

    @Override
    public Employee update(Long id, Employee Employee) {
        employeeRepository.deleteById(id);
        employeeRepository.save(Employee);
        return Employee;
    }

    @Override
    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return "Success";
    }

    @Override
    public EmployeeInfoDto getInfoById(Long id) {
        EmployeeDto employeeDto = modelMapper.map(employeeRepositoryQuery.findEmployeeById(id), EmployeeDto.class);
        Department department = departmentRepositoryQuery.findDepartmentById(id);
        EmployeeInfoDto employeeInfoDto = new EmployeeInfoDto(employeeDto, department);
        return employeeInfoDto;
    }
}
