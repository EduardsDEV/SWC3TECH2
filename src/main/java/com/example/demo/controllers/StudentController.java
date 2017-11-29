package com.example.demo.controllers;
import com.example.demo.accounts.Account;
import com.example.demo.models.Course;
import com.example.demo.models.Student;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class StudentController {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;


    @Autowired
    public StudentController(CourseRepository courseRepository, StudentRepository studentRepository, AccountRepository accountRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.accountRepository = accountRepository;
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

    @GetMapping("/student/apply")
    public ModelAndView applyForCourse(
            @RequestParam(name = "id", defaultValue = "0")
                    long courseId,
            Authentication authentication)
    {

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String username = userDetails.getUsername();
        Account ac = accountRepository.findByUsername(username);

        Course c = courseRepository.getCourseById(courseId);
        Student s = studentRepository.getStudentByAccount(ac);
        s.setRequestTime(LocalDateTime.now());
        c.getRequestedStudents().add(s);
        courseRepository.save(c);

        ModelAndView mv = new ModelAndView("courseinfo");
        mv.getModel().put("course", courseRepository.getCourseById(courseId));

        return mv;


    }

}
