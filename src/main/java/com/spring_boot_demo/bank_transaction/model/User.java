package com.spring_boot_demo.bank_transaction.model;

import com.spring_boot_demo.bank_transaction.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private Role role;
    @OneToOne
    private Account account;


    public User(String firstName, String lastname, Role role, Account account) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.role = role;
        this.account = account;
    }

}
