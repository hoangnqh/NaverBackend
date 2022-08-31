package com.example.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "product_id", nullable = false)
    private Long id;
    @Column(name = "name_product", nullable = false)
    private String nameProduct;
    private String type;
    private String size;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private BigDecimal price;
    @JsonIgnore
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL
    )
    private List<CartItem> cartItems;

    public Product(String nameProduct, String type, String size, Long quantity, BigDecimal price){
        this.nameProduct = nameProduct;
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }
}
