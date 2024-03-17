package com.naher_farhsa.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

   // @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String hello() {
        return "hello world ⭐";
    }
}
