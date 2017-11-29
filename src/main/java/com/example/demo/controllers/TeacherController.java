package com.example.demo.controllers;


import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/courses")
    public String loadCoursePage() {

        return "course";
    }

    @GetMapping("/teacher/courses/add")
    public ModelAndView loadAddCoursePage() {
        ModelAndView mv = new ModelAndView("addcourse");
        mv.getModel().put("teachersList", teacherRepository.findAll());
        return mv;
    }
}
