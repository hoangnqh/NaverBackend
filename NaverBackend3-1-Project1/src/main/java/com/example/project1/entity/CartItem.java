package com.example.project1.entity;

import com.example.project1.entity.PKId.CartItemPKId;
import com.example.project1.service.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cart_item")
public class CartItem {
    @EmbeddedId
    private CartItemPKId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity_wished", nullable = false)
    private Long quantityWished;
    @Column(name = "date_added", nullable = false)
    private Date dateAdded;
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    public void updateQuantitywished(Long quantityWished){
        Date date = new Date();
        this.dateAdded = date;
        BigDecimal x = new BigDecimal(this.quantityWished);
        BigDecimal price = this.totalAmount.divide(x);
        this.quantityWished += quantityWished;
        x = new BigDecimal(this.quantityWished);
        this.totalAmount = x.multiply(price);
    }

}
