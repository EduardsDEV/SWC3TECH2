package com.example.demo.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/student/**").access("hasRole(\"ROLE_STUDENT\") or hasRole(\"ROLE_TEACHER\")") //this is to allow only to student role
                .antMatchers("/teacher/**").access("hasRole(\"ROLE_TEACHER\")") //this is to allow only to student role
                .antMatchers("/admin/**").access("hasRole(\"ROLE_ADMIN\")") //this is to allow only to student role
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "select username,password,enabled from accounts where username=?")
                .authoritiesByUsernameQuery(
                        "select b.username, a.role_name from roles a, accounts b where b.username=? and a.id=b.role_id");

    }
}