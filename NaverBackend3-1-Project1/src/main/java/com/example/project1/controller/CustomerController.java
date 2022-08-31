package com.example.project1.controller;

import com.example.project1.entity.*;
import com.example.project1.payload.request.NewItem;
import com.example.project1.payload.response.ResponseObject;
import com.example.project1.repository.jpa.CartItemRepository;
import com.example.project1.repository.jpa.CartRepository;
import com.example.project1.repository.jpa.CustomerRepository;
import com.example.project1.repository.jpa.ProductRepository;
import com.example.project1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/get-all-customer")
    public List<Customer> getAll(){
        return customerService.getAllCustomer();
    }

}
