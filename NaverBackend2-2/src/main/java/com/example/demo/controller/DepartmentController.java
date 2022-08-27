package com.example.demo.controller;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> create(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.create(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Department department){
        return ResponseEntity.ok(departmentService.update(id, department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return  ResponseEntity.ok(departmentService.delete(id));
    }

    @GetMapping("/{id}/countEmployee")
    public ResponseEntity<?> getDepartmentWithCount(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentWithCountEmployee(id));
    }
}
