package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> create(@RequestBody Employee Employee){
        return ResponseEntity.ok(employeeService.create(Employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return  ResponseEntity.ok(employeeService.delete(id));
    }

    @GetMapping("/{id}/info")
    public ResponseEntity<?> getInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getInfoById(id));
    }
}
