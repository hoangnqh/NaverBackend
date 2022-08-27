package com.example.demo.service.impl;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.Query.DepartmentRepositoryQuery;
import com.example.demo.service.DepartmentService;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Resource
    DepartmentRepositoryQuery departmentRepositoryQuery;

    ModelMapper modelMapper;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return department;
    }

    @Override
    public Department create(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department update(Long id, Department department) {
        departmentRepository.deleteById(id);
        departmentRepository.save(department);
        return department;
    }

    @Override
    public String delete(Long id) {
        departmentRepository.deleteById(id);
        return "Success";
    }

    @Override
    public DepartmentDto getDepartmentWithCountEmployee(Long id) {
        DepartmentDto departmentDto = modelMapper.map(departmentRepository.findById(id), DepartmentDto.class);
        departmentDto.setCountEmployee(departmentRepositoryQuery.count(id));
        return departmentDto;
    }


}
