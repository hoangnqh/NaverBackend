package com.example.naverbackend12.repository;

import com.example.naverbackend12.repository.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private static ArrayList<User> users = new ArrayList<User>();
    static{
        users.add(new User(1, "Nguyen Quoc Huy Hoang1", 20, "Da bong"));
        users.add(new User(2, "Nguyen Quoc Huy Hoang2", 15, "Bong chuyen"));
        users.add(new User(3, "Nguyen Quoc Huy Hoang3", 12, "Cau long"));
        users.add(new User(4, "Nguyen Quoc Huy Hoang4", 16, "Game"));
        users.add(new User(5, "Nguyen Quoc Huy Hoang5", 19, "Anime"));
    }

    public List<User> getListUser(){
        return users.stream().sorted().collect(Collectors.toList());
    }

    public User getUserById(int id){
        for(User user: users){
            if(user.getId() == id) return user;
        }
        return null;
    }
}
