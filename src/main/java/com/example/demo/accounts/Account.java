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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "account_type")
public abstract class Account {

    @Id
    @GeneratedValue()
    @Column(name = "account_id")
    private long accountId;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @JsonBackReference
    private Collection<Role> roles;

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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean hasPrivilege(String privilege) {
        for(Role r : roles){
            //if (r.getName().equals(LoginHandler.Role.ADMIN.getName())) {
            for(Privilege p : r.getPrivileges()){
                if(p.getName().equals(privilege)){
                    return true;
                }
            }
        }
        return false;
    }
}
