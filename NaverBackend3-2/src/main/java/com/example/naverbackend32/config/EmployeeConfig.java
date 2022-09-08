package com.example.naverbackend32.config;


import com.example.naverbackend32.service.impl.DepartmentServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class EmployeeConfig {
    private Logger logger = LoggerFactory.getLogger(EmployeeConfig.class);

    @Before("execution(* com.example.naverbackend32.service.impl.EmployeeServiceImpl.getEmployeeDto(..))")
    public void beforeGetEmployeeDto(JoinPoint joinPoint) {
        logger.info("Before employeeDto method");
    }

    @After("execution(* com.example.naverbackend32.service.impl.EmployeeServiceImpl.getEmployeeDto(..))")
    public void afterGetEmployeeDto(JoinPoint joinPoint) {
        logger.info("After employeeDto method");
    }

    @AfterThrowing("execution(* com.example.naverbackend32.service.impl.EmployeeServiceImpl.getEmployeeDto(..))")
    public void afterThrowingGetEmployeeDto(JoinPoint joinPoint) {
        logger.info("After throwing employeeDto method!!");
    }

}
