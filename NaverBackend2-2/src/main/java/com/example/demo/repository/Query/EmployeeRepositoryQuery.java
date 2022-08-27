package com.example.demo.repository.Query;

import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeRepositoryQuery {
    @Select("SELECT * FROM employee WHERE employeeId=#{id}")
    Employee findEmployeeById(Long id);
}
