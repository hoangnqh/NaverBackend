package com.example.project1.service.impl;

import com.example.project1.entity.Customer;
import com.example.project1.repository.jpa.CartItemRepository;
import com.example.project1.repository.jpa.CartRepository;
import com.example.project1.repository.jpa.CustomerRepository;
import com.example.project1.repository.jpa.ProductRepository;
import com.example.project1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
