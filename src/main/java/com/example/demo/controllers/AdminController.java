package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.CourseRequest;
import com.example.demo.models.Student;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.CourseRequestRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    private final CourseRequestRepository courseRequestRepository;

    public AdminController(CourseRepository courseRepository, StudentRepository studentRepository, AccountRepository accountRepository, CourseRequestRepository courseRequestRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.accountRepository = accountRepository;
        this.courseRequestRepository = courseRequestRepository;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/admin/showcourses")
    public ModelAndView showCourses() {
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
        mv.getModel().put("courseRequest", courseById.getCourseRequests());

        return mv;
    }

    @GetMapping("/admin/approve")
    public ModelAndView approveRequest(
            @RequestParam(name = "courseId", defaultValue = "0")
                    long courseId,
            @RequestParam(name = "courseRequestId", defaultValue = "0")
                    long courseRequestId
    ) {
        CourseRequest cr = courseRequestRepository.findOne(courseRequestId);

        Course c = courseRepository.getCourseById(courseId);
        List<Student> assignedStudents = c.getAssignedStudents();
        if (assignedStudents != null) {
            assignedStudents.add(cr.getStudent());
        }else{
            assignedStudents = new ArrayList<>();
            assignedStudents.add(cr.getStudent());
        }

        c.getCourseRequests().remove(cr);
        courseRequestRepository.delete(courseRequestId);
        courseRepository.save(c);

        return new ModelAndView(new RedirectView("/admin/course/requests?id=" + courseId, true));


    }

}
