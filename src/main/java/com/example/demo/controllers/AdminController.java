package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
