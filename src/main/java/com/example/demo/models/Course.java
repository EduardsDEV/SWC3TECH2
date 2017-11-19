package com.example.demo.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String danishName;
    private String englishName;
    private String studyProgramme;
    private int ects;
    private String mandatory;
    private String courseLanguage;
    private int minStudents;
    private int expStudents;
    private int maxStudents;
    private String prerequisites;
    private String outcome;
    private String content;
    private String learningActivities;
    private String examForm;
    //private List<Teacher> teachers;
    //private List<Student> students;


    public Course(long id, String danishName, String englishName, String studyProgramme, int ects, String mandatory,
                  String courseLanguage, int minStudents, int expStudents, int maxStudents, String prerequisites,
                  String outcome, String content, String learningActivities, String examForm) {
        this.id = id;
        this.danishName = danishName;
        this.englishName = englishName;
        this.studyProgramme = studyProgramme;
        this.ects = ects;
        this.mandatory = mandatory;
        this.courseLanguage = courseLanguage;
        this.minStudents = minStudents;
        this.expStudents = expStudents;
        this.maxStudents = maxStudents;
        this.prerequisites = prerequisites;
        this.outcome = outcome;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
    }

    public Course() {
    }

    public long getId() {
        return id;
    }

    public String getDanishName() {
        return danishName;
    }

    public void setDanishName(String danishName) {
        this.danishName = danishName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getStudyProgramme() {
        return studyProgramme;
    }

    public void setStudyProgramme(String studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        this.courseLanguage = courseLanguage;
    }

    public int getMinStudents() {
        return minStudents;
    }

    public void setMinStudents(int minStudents) {
        this.minStudents = minStudents;
    }

    public int getExpStudents() {
        return expStudents;
    }

    public void setExpStudents(int expStudents) {
        this.expStudents = expStudents;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearningActivities() {
        return learningActivities;
    }

    public void setLearningActivities(String learningActivities) {
        learningActivities = learningActivities;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

//    public List<Teacher> getTeachers() {
//        return teachers;
//    }
//
//    public void setTeachers(List<Teacher> teachers) {
//        this.teachers = teachers;
//    }


}
