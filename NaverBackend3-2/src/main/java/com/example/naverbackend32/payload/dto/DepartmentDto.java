package com.example.naverbackend32.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentDto {
    private Long departmentId;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 10, max = 50, message = "Length from 10 to 50 characters")
    private String deptName;

    @NotEmpty(message = "Description must not be empty")
    private String description;

    @Valid
    private List<EmployeeDto> employeeDtos;
}
