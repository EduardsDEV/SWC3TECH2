package com.example.demo.accounts;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by edwar on 11/18/2017.
 */
@DiscriminatorValue("TEACHER")
@Table(name = "teacher_accounts")
@Entity
public class TeacherAccount extends Account {
}
