package com.example.project1.controller;

import com.example.project1.entity.Cart;
import com.example.project1.entity.CartItem;
import com.example.project1.entity.Customer;
import com.example.project1.entity.Product;
import com.example.project1.payload.request.InfoCartItem;
import com.example.project1.payload.request.NewItem;
import com.example.project1.payload.response.ResponseObject;
import com.example.project1.repository.mybatis.CartItemMybatisRepository;
import com.example.project1.service.CartItemService;
import com.example.project1.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/v1")
public class CartItemController {
    @Autowired
    CartItemService cartItemService;

    @PostMapping("/update-new-item")
    public ResponseEntity<ResponseObject> updateNewItem(@RequestBody NewItem newItem){
        return cartItemService.updateNewItem(newItem);
    }

    @GetMapping("/info-cart-item")
    public ResponseEntity<ResponseObject> getInfo(@RequestBody InfoCartItem infoCartItem){
        return cartItemService.getInfo(infoCartItem);
    }
}
