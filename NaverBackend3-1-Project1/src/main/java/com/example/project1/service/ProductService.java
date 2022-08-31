package com.example.project1.service;

import com.example.project1.entity.Product;
import com.example.project1.payload.request.PriceCondition;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public List<Product> getPriceCondition(PriceCondition priceCondition);
}
