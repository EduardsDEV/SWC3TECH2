package com.example.demo.controllers;


import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
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

    @GetMapping("/teacher/courses/applied")
    public ModelAndView loadAppliedPage(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        ModelAndView mv = new ModelAndView("approvedstudents");
        mv.getModel().put("assignedStudents", courseRepository.getCourseById(id).getAssignedStudents());
        return mv;
    }
}
