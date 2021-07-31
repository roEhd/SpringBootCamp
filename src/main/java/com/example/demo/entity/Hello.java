package com.example.demo.entity;

import lombok.Data;

@Data
public class Hello {
    String name;

    public Hello(String name) {
        this.name = name;
    }
}
