package com.example.naverbackend32.payload.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class EmployeeDto {
    private Long employeeId;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 10, max = 50, message = "Length from 10 to 50 characters")
    private String name;

    private Date birthDate;

    private String gender;

    @NotEmpty(message = "Email must no be empty")
    @Email(message = "Email is wrong format")
    private String email;
}
