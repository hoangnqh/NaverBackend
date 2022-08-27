package com.example.demo.designpattern.subclass;

import com.example.demo.designpattern.superclass.Computer;

public class Server implements Computer {
    @Override
    public String getType() {
        return "Server";
    }
}
