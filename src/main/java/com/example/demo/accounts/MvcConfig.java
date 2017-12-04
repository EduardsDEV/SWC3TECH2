package com.example.demo.accounts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by edwar on 11/22/2017.
 */
@Configuration
public class MvcConfig {
//    @Primary
//    @Bean(name = "dataSource")
//    public DriverManagerDataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ikea");
//        driverManagerDataSource.setUsername("root");
//        driverManagerDataSource.setPassword("");
//        return driverManagerDataSource;
//    }

        @Primary
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://ikeadb.cx5gjcsbwv9m.us-west-2.rds.amazonaws.com:3306/iKEA");
        driverManagerDataSource.setUsername("adminikea");
        driverManagerDataSource.setPassword("adminikea");
        return driverManagerDataSource;
    }


}
