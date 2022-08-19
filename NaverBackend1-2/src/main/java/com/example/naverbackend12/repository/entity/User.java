package com.example.naverbackend12.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User implements Comparable<User>{
    private int id;
    private String ten;
    private int tuoi;
    private String sothich;

    @Override
    public int compareTo(User compareUser) {
        int compareTuoi = ((User) compareUser).getTuoi();
        return compareTuoi - this.tuoi;
    }
}
