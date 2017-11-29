package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {
    private final CourseRepository courseRepository;

    public AdminController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/admin/showcourses")
    public ModelAndView showCourses(){
        ModelAndView mv = new ModelAndView("adminpage");
        mv.getModel().put("courseList", courseRepository.findAll());
        return mv;
    }
    //for login security part
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/course/requests")
    public ModelAndView seeCourseRequests(
                                   @RequestParam(name = "id", defaultValue = "0")
                                           long id) {

        ModelAndView mv = new ModelAndView("courserequests");
        Course courseById = courseRepository.getCourseById(id);
        mv.getModel().put("course", courseById);
        return mv;


    }
}
