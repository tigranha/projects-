package com.spring_boot_demo.bank_transaction.model;

import com.spring_boot_demo.bank_transaction.model.enums.TransactionStatus;
import com.spring_boot_demo.bank_transaction.model.enums.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate transactionDate;
    private TransactionType type;
    private TransactionStatus status;
    private double transactionAmount;
    @ManyToOne
    private User user;

    public Transaction(LocalDate transactionDate, TransactionType type, double transactionAmount, User user) {
        this.transactionDate = LocalDate.parse(transactionDate.format(DateTimeFormatter.ofPattern("d-MM-y HH:mm:ss")));
        this.type = type;
        this.status = TransactionStatus.PENDING;
        this.transactionAmount = transactionAmount;
        this.user = user;
    }


}
