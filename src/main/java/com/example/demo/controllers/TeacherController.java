package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {


    @GetMapping("/courses")
    public String loadCoursePage() {

        return "course";
    }

    @GetMapping("/courses/edit")
    public String loadEditCoursePage() {

        return "editcourse";
    }

    @GetMapping("/courses/add")
    public String loadAddCoursePage() {

        return "addcourse";
    }
}
