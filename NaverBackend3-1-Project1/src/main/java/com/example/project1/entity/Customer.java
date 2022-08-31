package com.example.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(name = "customer_id", nullable = false)
    private Long id;
    @Column(name = "customer_name", nullable = false)
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_no", nullable = false)
    private String phoneNo;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Customer(String name, String address, String phoneNo){
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

}
