package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Teacher;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    public CourseController(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
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
            @RequestParam(name = "mandatory", defaultValue = "NOT_MANDATORY")
                    String mandatory,
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

        Course c = new Course(id, danishName, englishName, studyProgramme, ects, mandatory, courseLanguage, minStudents,
                expStudents, maxStudents, prerequisites, outcome, content, learningActivities, examForm, teacherCollection);
        courseRepository.save(c);

        ModelAndView mv = new ModelAndView("course");
        mv.getModel().put("courseList", courseRepository.findAll());
        mv.getModel().put("course", c);

        return mv;
    }

    @GetMapping("/course/edit")
    public ModelAndView editCourse(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        System.out.println("id = " + id);
        ModelAndView mv = new ModelAndView("editcourse");

        mv.getModel().put("course", courseRepository.getCourseById(id));

        return mv;


    }
    @GetMapping("/course/show")
    public ModelAndView showCourse(){
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
