package com.spring_boot_demo.bank_transaction.controller;

import com.spring_boot_demo.bank_transaction.model.Transaction;
import com.spring_boot_demo.bank_transaction.model.User;
import com.spring_boot_demo.bank_transaction.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/user/{id}/transaction")
    public List<Transaction> getUserTransactions(@PathVariable Long id) {
        return transactionService.getUserTransactions(id);
    }

    @GetMapping("api/user/id/transaction/filter?date= ")
    public  List<Transaction> filterTransactionsByDatePerUser(User user, LocalDate data){
        List<Transaction> filteredList = new ArrayList<>();
        List<Transaction> list = getUserTransactions(user.getId());
        for (Transaction transaction : list) {
            if (transaction.getTransactionDate().isAfter(data)){
                filteredList.add(transaction);
            }
        }
        return filteredList;
    }
}
