package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public String greet(String name) {
        return String.format("welcome, %s", name);
    }
}
