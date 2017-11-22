package com.example.demo.controllers;

import com.example.demo.accounts.Account;
import com.example.demo.models.Course;
import com.example.demo.models.Teacher;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final AccountRepository accountRepository;


    @Autowired
    public CourseController(CourseRepository courseRepository, TeacherRepository teacherRepository, AccountRepository accountRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/course/saveandget")
    public ModelAndView saveAndShow(
            @RequestParam(name = "id", defaultValue = "-1")
                    long id,
            @RequestParam(name = "danishName", defaultValue = "NO_NAME")
                    String danishName,
            @RequestParam(name = "englishName", defaultValue = "NO_NAME")
                    String englishName,
            @RequestParam(name = "studyProgramme", defaultValue = "NO_STUDY_PROGRAMME")
                    String studyProgramme,
            @RequestParam(name = "ects", defaultValue = "NO_ECTS")
                    int ects,
            @RequestParam(name = "mandatory")
                    boolean mandatory,
            @RequestParam(name = "courseLanguage", defaultValue = "NO_LANGUAGE")
                    String courseLanguage,
            @RequestParam(name = "minStudents", defaultValue = "NOT_STATED")
                    int minStudents,
            @RequestParam(name = "expStudents", defaultValue = "NOT_STATED")
                    int expStudents,
            @RequestParam(name = "maxStudents", defaultValue = "NOT_STATED")
                    int maxStudents,
            @RequestParam(name = "prerequisites", defaultValue = "NO_PREREQUISITES")
                    String prerequisites,
            @RequestParam(name = "outcome", defaultValue = "NO_OUTCOME")
                    String outcome,
            @RequestParam(name = "content", defaultValue = "NO_CONTENT")
                    String content,
            @RequestParam(name = "learningActivities", defaultValue = "NO_LEARNING_ACTIVITIES")
                    String learningActivities,
            @RequestParam(name = "examForm", defaultValue = "NO_EXAM_FORM")
                    String examForm,
            @RequestParam(name = "teachers", defaultValue = "0")
                    Long[] teachers
    ) {

        final Iterable<Teacher> teacherIterable = teacherRepository.findAll(Arrays.asList(teachers));
        final List<Teacher> teacherCollection = new ArrayList<>(teachers.length);
        teacherIterable.forEach(teacher -> teacherCollection.add(teacher));
        Course c = courseRepository.getCourseById(id);
        if (c == null) {
            c = new Course(danishName, englishName, studyProgramme, ects, mandatory, courseLanguage, minStudents,
                    expStudents, maxStudents, prerequisites, outcome, content, learningActivities, examForm, teacherCollection);
        }else {

            c.setDanishName(danishName);
            c.setEnglishName(englishName);
            c.setStudyProgramme(studyProgramme);
            c.setEcts(ects);
            c.setMandatory(mandatory);
            c.setCourseLanguage(courseLanguage);
            c.setMinStudents(minStudents);
            c.setExpStudents(expStudents);
            c.setMaxStudents(maxStudents);
            c.setPrerequisites(prerequisites);
            c.setOutcome(outcome);
            c.setContent(content);
            c.setLearningActivities(learningActivities);
            c.setExamForm(examForm);
            c.setTeachers(teacherCollection);
        }

        courseRepository.save(c);



        ModelAndView mv = new ModelAndView("course");
        mv.getModel().put("courseList", courseRepository.findAll());
        mv.getModel().put("course", c);

        return mv;
    }

    @GetMapping("/course/edit")
    public ModelAndView editCourse(Authentication authentication,
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        //System.out.println("id = " + id);
        ModelAndView mv = new ModelAndView("editcourse");

//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String username = userDetails.getUsername();
//        Account ac = accountRepository.findByUsername(username);

        Course courseById = courseRepository.getCourseById(id);
        mv.getModel().put("course", courseById);
        mv.getModel().put("teachersList", teacherRepository.findAll());

        return mv;


    }

    @GetMapping("/course/show")
    public ModelAndView showCourse() {
        ModelAndView mv = new ModelAndView("course");
        mv.getModel().put("courseList", courseRepository.findAll());
        return mv;
    }

    @GetMapping("/course/delete")
    public ModelAndView deleteCourse(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        System.out.println("id = " + id);
        Course c = courseRepository.getCourseById(id);
        courseRepository.delete(c);

        ModelAndView mv = new ModelAndView("course");

        mv.getModel().put("courseList", courseRepository.findAll());

        return mv;


    }
}
