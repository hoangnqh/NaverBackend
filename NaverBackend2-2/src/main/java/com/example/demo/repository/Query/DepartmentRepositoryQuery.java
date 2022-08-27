package com.example.demo.repository.Query;

import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentRepositoryQuery {
    @Select("SELECT count(EMPLOYEE.employeeId) FROM EMPLOYEE WHERE EMPLOYEE.employeeId=#{id}")
    Long count(Long id);

    @Select("SELECT * FROM DEPARTMENT WHERE id=#{id}")
    Department findDepartmentById(Long id);
}
