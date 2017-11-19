package com.example.demo.accounts;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by edwar on 11/18/2017.
 */
@DiscriminatorValue("ADMIN")
@Entity
@Table(name = "admin_accounts")
public class AdminAccount extends Account {
}
