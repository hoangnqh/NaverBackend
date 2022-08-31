package com.example.project1.service.impl;

import com.example.project1.entity.Product;
import com.example.project1.payload.request.PriceCondition;
import com.example.project1.repository.jpa.ProductRepository;
import com.example.project1.repository.mybatis.ProductMybatisRepository;
import com.example.project1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Resource
    ProductMybatisRepository productMybatisRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public List<Product> getPriceCondition(PriceCondition priceCondition) {
        switch (priceCondition.getCondition()){
            case "LESS_THAN":
                return productMybatisRepository.priceConditionLessThan(priceCondition.getPrice());
            case "GREATER_THAN":
                return productMybatisRepository.priceConditionGreaterThan(priceCondition.getPrice());
            case "EQUAL":
                return productMybatisRepository.priceConditionEqual(priceCondition.getPrice());
            default:
                return null;
        }
    }
}
