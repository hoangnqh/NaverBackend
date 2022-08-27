package com.example.demo.designpattern.factory;

import com.example.demo.designpattern.subclass.PC;
import com.example.demo.designpattern.subclass.Server;
import com.example.demo.designpattern.superclass.Computer;
import org.springframework.stereotype.Component;

@Component
public class ComputerFactory {
    public Computer getComputer(String computer){
        computer = computer.toUpperCase();
        if(computer.equals("PC")){
            return new PC();
        }
        else return new Server();
    }
}
