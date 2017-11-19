package com.example.demo.accounts;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by edwar on 11/18/2017.
 */
@DiscriminatorValue("STUDENT")
@Entity
@Table(name = "student_accounts")
public class StudentAccount extends Account {
}
