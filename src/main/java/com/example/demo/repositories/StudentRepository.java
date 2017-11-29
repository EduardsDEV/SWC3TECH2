package com.example.demo.repositories;

import com.example.demo.accounts.Account;
import com.example.demo.models.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 11/29/2017.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student getStudentById(long id);
    Student getStudentByAccount(Account account);
}
