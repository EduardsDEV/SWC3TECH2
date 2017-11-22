package com.example.demo.accounts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by edwar on 11/18/2017.
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue()
    @Column(name = "account_id")
    private long accountId;

    @Column(name = "username", unique = true, nullable = false)
    @Email
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne
    private Role role;



    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
