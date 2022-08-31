package com.example.project1.controller;

import com.example.project1.entity.Product;
import com.example.project1.payload.request.PriceCondition;
import com.example.project1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("get-all-product")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/price-condition")
    public List<Product> getPriceCondition(@RequestBody PriceCondition priceCondition){
        return productService.getPriceCondition(priceCondition);
    }
}
