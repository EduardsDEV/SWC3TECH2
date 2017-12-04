package com.example.demo.controllers;

import com.example.demo.accounts.Account;
import com.example.demo.models.Course;
import com.example.demo.models.CourseRequest;
import com.example.demo.models.Student;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.CourseRequestRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

@Controller
public class StudentController {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    private final CourseRequestRepository courseRequestRepository;


    @Autowired
    public StudentController(CourseRepository courseRepository, StudentRepository studentRepository, AccountRepository accountRepository, CourseRequestRepository courseRequestRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.accountRepository = accountRepository;
        this.courseRequestRepository = courseRequestRepository;
    }


//    @GetMapping("/student/showcourses")
//    public String loadAddCoursePage() {
//
//        return "viewcourses";
//    }

    @GetMapping("/student/showcourses")
    public ModelAndView showCourses() {
        ModelAndView mv = new ModelAndView("viewcourses");
        mv.getModel().put("courseList", courseRepository.findAll());
        return mv;
    }


    @GetMapping("/student/courseinfo")
    public ModelAndView viewCourseInfo(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        ModelAndView mv = new ModelAndView("courseinfo");
        mv.getModel().put("course", courseRepository.getCourseById(id));
        return mv;
    }

    @GetMapping("/student/apply")
    public ModelAndView applyForCourse(
            @RequestParam(name = "id", defaultValue = "0")
                    long courseId,
            Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Account ac = accountRepository.findByUsername(username);

        Course c = courseRepository.getCourseById(courseId);
        Student s = studentRepository.getStudentByAccount(ac);

        CourseRequest cr = new CourseRequest();
        cr.setStudent(s);
        cr.setCourse(c);
        cr.setTimestamp(LocalDateTime.now());

        c.getCourseRequests().add(cr);
        courseRequestRepository.save(cr);

        courseRepository.save(c);


        return new ModelAndView(new RedirectView("/student/showcourses", true));
    }

}
