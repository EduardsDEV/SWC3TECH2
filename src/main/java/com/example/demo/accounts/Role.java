package com.example.demo.accounts;
import com.example.demo.accounts.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;


// Code taken from http://www.baeldung.com/role-and-privilege-for-spring-security-registration
// and adapted to our project
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "role_id")
    private long id;

    @Column(name = "role_name")
    private String name;


    public Role(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
