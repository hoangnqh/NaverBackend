package com.example.project1.repository.mybatis;

import com.example.project1.entity.CartItem;
import com.example.project1.payload.response.CartItemResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartItemMybatisRepository {
    @Select("SELECT * " +
                    "FROM CART_ITEM CI " +
                    "JOIN CUSTOMER CTM ON CTM.CART_ID = CI.CART_ID " +
                   "JOIN PRODUCT P ON P.PRODUCT_ID = CI.PRODUCT_ID " +
                    "WHERE CTM.CUSTOMER_ID = #{customerId} AND P.NAME_PRODUCT = #{nameProduct} " +
                    "limit #{limit} offset #{offset}"
    )
    @Results(
            value = {
                    @Result(property = "cartId", column = "cart_id"),
                    @Result(property = "productId", column = "product_id"),
                    @Result(property = "nameProduct", column = "name_product"),
                    @Result(property = "type", column = "type"),
                    @Result(property = "size", column = "size"),
                    @Result(property = "quantity", column = "quantity_wished"),
                    @Result(property = "price", column = "price"),
                    @Result(property = "totalAmount", column = "total_amount"),
                    @Result(property = "dateAdded", column = "date_added")
            }
    )
    public List<CartItemResponse> findByLimitAndOffset(Long customerId, String nameProduct, Long offset, Long limit);
}
