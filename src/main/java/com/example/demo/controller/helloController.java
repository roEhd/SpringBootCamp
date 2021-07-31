package com.example.demo.controller;

import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Controller
@Slf4j
@RequiredArgsConstructor
public class helloController {

    final MemberService memberService;

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(String name){
        return memberService.greet(name);
    }


    @GetMapping("hello-mvc")
    public String helloTemplate(String name, Model model) {

        model.addAttribute("name", name);
        return "hello-template";
    }
    @PostConstruct
    public void postConstruct() {
        log.info("I am already constructed");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("I will be destroyed");
    }

}
