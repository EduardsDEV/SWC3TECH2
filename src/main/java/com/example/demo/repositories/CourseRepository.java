package com.example.demo.repositories;

import com.example.demo.models.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 11/16/2017.
 */
public interface CourseRepository extends CrudRepository<Course, Integer> {
    Course getCourseById(long id);
    //void deleteById(long id);
}
