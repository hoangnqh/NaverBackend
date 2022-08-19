package com.example.naverbackend12.service;

import com.example.naverbackend12.repository.UserRepository;
import com.example.naverbackend12.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserserviceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getListUser() {
        return userRepository.getListUser();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
}
