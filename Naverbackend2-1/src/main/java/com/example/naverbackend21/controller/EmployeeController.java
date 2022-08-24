package com.example.naverbackend21.controller;

import com.example.naverbackend21.entity.Employee;
import com.example.naverbackend21.service.EmployeeService;
import com.example.naverbackend21.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService EmployeeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployee(){
        return ResponseEntity.ok(EmployeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(EmployeeService.getEmployeeById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createEmployee(@RequestBody Employee Employee){
        return ResponseEntity.ok(EmployeeService.createEmployee(Employee));
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        EmployeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        EmployeeService.deleteEmployee(id);
    }
    
}
