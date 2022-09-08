package com.example.naverbackend32.controller;

import com.example.naverbackend32.payload.response.BaseResponse;
import com.example.naverbackend32.payload.dto.EmployeeDto;
import com.example.naverbackend32.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/test-employeeDto")
    public ResponseEntity<?> testEmployeeDto(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok().body(
                new BaseResponse("OK", "success", employeeService.getEmployeeDto(employeeDto)));
    }
}
