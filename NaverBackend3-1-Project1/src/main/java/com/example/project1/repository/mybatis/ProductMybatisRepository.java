package com.example.project1.repository.mybatis;

import com.example.project1.entity.Product;
import com.example.project1.payload.request.PriceCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMybatisRepository {
    @Select(value = "SELECT * FROM PRODUCT WHERE price < #{price}")
    @Results(value = {
            @Result(property = "id", column = "product_id"),
            @Result(property = "nameProduct", column = "name_product")

    })
    public List<Product> priceConditionLessThan(BigDecimal price);

    @Select("SELECT * FROM PRODUCT WHERE price > #{price}")
    @Results(value = {
            @Result(property = "id", column = "product_id"),
            @Result(property = "nameProduct", column = "name_product")

    })
    public List<Product> priceConditionGreaterThan(BigDecimal price);

    @Select("SELECT * FROM PRODUCT WHERE price = #{price}")
    @Results(value = {
            @Result(property = "id", column = "product_id"),
            @Result(property = "nameProduct", column = "name_product")

    })
    public List<Product> priceConditionEqual(BigDecimal price);

    @Select("SELECT * FROM PRODUCT")
    public  List<Product> findAllProduct();
}