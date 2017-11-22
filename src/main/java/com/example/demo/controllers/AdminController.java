package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    //for login security part
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
