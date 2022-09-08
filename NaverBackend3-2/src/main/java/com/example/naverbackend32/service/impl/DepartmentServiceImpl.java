package com.example.naverbackend32.service.impl;

import com.example.naverbackend32.payload.dto.DepartmentDto;
import com.example.naverbackend32.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Override
    public DepartmentDto getDepartmentDto(DepartmentDto departmentDto) {
        logger.info("INFO: " + departmentDto.toString());
        return departmentDto;
    }
}
