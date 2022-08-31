package com.example.project1.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoCartItem {
    private Long customerId;
    private String nameProduct;
    private Long offset;
    private Long limit;
}
