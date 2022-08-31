package com.example.project1.repository.jpa;

import com.example.project1.entity.CartItem;
import com.example.project1.entity.PKId.CartItemPKId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemPKId> {
}
