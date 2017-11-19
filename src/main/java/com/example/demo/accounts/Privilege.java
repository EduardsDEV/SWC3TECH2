package com.example.demo.accounts;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;


// Code taken from http://www.baeldung.com/role-and-privilege-for-spring-security-registration
// and adapted to our project
@Entity
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "privilege_id")
    private long id;

    @Column(name = "privilege_name")
    private String name;

    @ManyToMany(mappedBy = "privileges", targetEntity = Role.class)
    @JsonBackReference
    private Collection<Role> roles;

    public Privilege() {
        super();
    }

    public Privilege(final String name) {
        super();
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
