package com.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TestAuthController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/hello-secure")
    public String helloSecure(){
        return "hello world secured";
    }

}
