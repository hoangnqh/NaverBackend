package com.example.project1.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    private Long cartId;
    private Long productId;
    private String nameProduct;
    private String type;
    private String size;
    private Long quantity;
    private BigDecimal price;
    private BigDecimal totalAmount;
    private Date dateAdded;
}
