package com.example.project1.service;

import com.example.project1.payload.request.InfoCartItem;
import com.example.project1.payload.request.NewItem;
import com.example.project1.payload.response.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface CartItemService {
    ResponseEntity<ResponseObject> getInfo(InfoCartItem infoCartItem);

    ResponseEntity<ResponseObject> updateNewItem(NewItem newItem);
}
