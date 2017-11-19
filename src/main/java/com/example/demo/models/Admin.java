package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by edwar on 11/17/2017.
 */
@Entity
public class Admin {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String password;

}
