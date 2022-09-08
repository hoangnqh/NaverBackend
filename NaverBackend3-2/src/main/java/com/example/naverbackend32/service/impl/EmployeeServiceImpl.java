package com.example.naverbackend32.service.impl;

import com.example.naverbackend32.payload.dto.EmployeeDto;
import com.example.naverbackend32.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Override
    public EmployeeDto getEmployeeDto(EmployeeDto employeeDto) {
        logger.info("INFO: " + employeeDto.toString());
        return employeeDto;
    }
}
