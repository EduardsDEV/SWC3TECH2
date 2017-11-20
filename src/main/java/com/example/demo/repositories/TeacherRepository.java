package com.example.demo.repositories;

import com.example.demo.models.Teacher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 11/20/2017.
 */
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
