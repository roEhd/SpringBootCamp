package com.example.demo.controller;

import com.example.demo.entity.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
public class helloRestController {



    @GetMapping("hello-map")
    public Map<String, Object> helloMap(String name){
        Map<String, Object> m = new HashMap<>();
        m.put("name", name);
        return m;
    }

    @GetMapping("hello-object")
    public Hello helloObject(String name) {
        Hello h = new Hello();
        h.setName(name);
        String a = "abs";
        a.getBytes(StandardCharsets.UTF_8);
        return h;
    }

}
