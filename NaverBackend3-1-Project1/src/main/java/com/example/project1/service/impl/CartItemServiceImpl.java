package com.example.project1.service.impl;

import com.example.project1.entity.Cart;
import com.example.project1.entity.CartItem;
import com.example.project1.entity.Customer;
import com.example.project1.entity.PKId.CartItemPKId;
import com.example.project1.entity.Product;
import com.example.project1.payload.request.InfoCartItem;
import com.example.project1.payload.request.NewItem;
import com.example.project1.payload.response.ResponseObject;
import com.example.project1.repository.jpa.CartItemRepository;
import com.example.project1.repository.jpa.CartRepository;
import com.example.project1.repository.jpa.CustomerRepository;
import com.example.project1.repository.jpa.ProductRepository;
import com.example.project1.repository.mybatis.CartItemMybatisRepository;
import com.example.project1.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Resource
    CartItemMybatisRepository cartItemMybatisRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
     @Override
    public ResponseEntity<ResponseObject> updateNewItem(NewItem newItem) {
        // Check customer ID
        Customer customer = customerRepository.findById(newItem.getCustomerId()).orElse(null);
        if(customer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Customer id is not exists", "")
            );
        }
        if(customer.getCart() == null){
            Cart cart = new Cart();
            cartRepository.save(cart);
            customer.setCart(cart);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        // Check product ID
        Product product = productRepository.findById(newItem.getProductId()).orElse(null);
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Product id is not exists", "")
            );
        }
        CartItem cartItem = cartItemRepository.findById(
                new CartItemPKId(customer.getCart().getCartId(), newItem.getProductId())).orElse(null);
        if(cartItem == null){
            BigDecimal total = new BigDecimal(newItem.getQuantity());
            total = total.multiply(product.getPrice());
            cartItem = new CartItem();
            cartItem.setId(new CartItemPKId(customer.getCart().getCartId(), newItem.getProductId()));
            cartItem.setCart(customer.getCart());
            cartItem.setProduct(product);
            cartItem.setQuantityWished(newItem.getQuantity());
            cartItem.setDateAdded(date);
            cartItem.setTotalAmount(total);
        }
        else{
            cartItem.updateQuantitywished(newItem.quantity);
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Success", "Add item success", cartItemRepository.save(cartItem))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> getInfo(InfoCartItem infoCartItem) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "ok",
                        cartItemMybatisRepository.findByLimitAndOffset(infoCartItem.getCustomerId(),
                                infoCartItem.getNameProduct(), infoCartItem.getOffset(), infoCartItem.getLimit()))
        );
    }
}
