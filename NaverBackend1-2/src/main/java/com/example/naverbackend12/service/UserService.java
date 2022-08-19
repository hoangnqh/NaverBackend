package com.example.naverbackend12.service;

import com.example.naverbackend12.repository.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getListUser();

    public User getUserById(int id);

}
