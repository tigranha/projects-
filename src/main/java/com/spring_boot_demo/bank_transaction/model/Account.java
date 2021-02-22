package com.spring_boot_demo.bank_transaction.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double balance;
    private long accountNumber;
    @OneToOne
    private User user;

    public Account(double balance, User user) {
        this.balance = balance;
        this.user = user;
        this.accountNumber = ThreadLocalRandom.current().nextLong(100000000000L, 9999999999999999L + 1);
    }

}

