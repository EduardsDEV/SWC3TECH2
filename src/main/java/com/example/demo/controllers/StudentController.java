package com.example.demo.controllers;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    private final CourseRepository courseRepository;


    @Autowired
    public StudentController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


//    @GetMapping("/student/showcourses")
//    public String loadAddCoursePage() {
//
//        return "viewcourses";
//    }

    @GetMapping("/student/showcourses")
    public ModelAndView showCourses(){
        ModelAndView mv = new ModelAndView("viewcourses");
        mv.getModel().put("courseList", courseRepository.findAll());
        return mv;
    }


    @GetMapping("/student/courseinfo")
    public ModelAndView viewCourseInfo(
                        @RequestParam(name = "id", defaultValue = "0")
                                long id){
        ModelAndView mv = new ModelAndView("courseinfo");
        mv.getModel().put("course", courseRepository.getCourseById(id));
        return mv;
    }

}
