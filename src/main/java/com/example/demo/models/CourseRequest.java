package com.example.demo.models;

import com.example.demo.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by edwar on 11/29/2017.
 */
@Entity
public class CourseRequest {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    @NotNull
    private Course course;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime timestamp;
    @ManyToOne
    private Student student;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
