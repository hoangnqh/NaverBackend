package com.example.naverbackend32.controller;

import com.example.naverbackend32.payload.dto.DepartmentDto;
import com.example.naverbackend32.payload.response.BaseResponse;
import com.example.naverbackend32.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/test-DepartmentDto")
    public ResponseEntity<?> testEmployeeDto(@RequestBody @Valid DepartmentDto departmentDto){
        return ResponseEntity.ok().body(
                new BaseResponse("OK", "success", departmentService.getDepartmentDto(departmentDto)));
    }
}
