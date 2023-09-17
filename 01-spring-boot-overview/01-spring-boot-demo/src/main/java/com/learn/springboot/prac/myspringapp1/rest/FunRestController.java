package com.learn.springboot.prac.myspringapp1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose a "/" that will return hello world!

    @GetMapping("/")
    public String sayHello() {
        return "Hello world!";
    }
}
