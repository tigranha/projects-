package com.spring_boot_demo.bank_transaction.service;

import com.spring_boot_demo.bank_transaction.model.Transaction;
import com.spring_boot_demo.bank_transaction.model.User;
import com.spring_boot_demo.bank_transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    final public TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void update(Transaction transaction, long id) {
        Optional<Transaction> transactionById = transactionRepository.findById(id);
        if (transactionById.isPresent()) {
            Transaction updatedTransaction = transactionById.get();

            if (transaction.getTransactionAmount() != 0) {
                updatedTransaction.setTransactionAmount(transaction.getTransactionAmount());
            }
            if (transaction.getTransactionDate() != null) {
                updatedTransaction.setTransactionDate(transaction.getTransactionDate());
            }
            if (transaction.getStatus() != null){
                updatedTransaction.setStatus(transaction.getStatus());
            }
            if (transaction.getType() != null){
                updatedTransaction.setType(transaction.getType());
            }


            transactionRepository.save(updatedTransaction);
        }
    }

    public Transaction getById(long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        Iterable<Transaction> all = transactionRepository.findAll();
        for (Transaction transaction : all) {
            list.add(transaction);
        }
        return list;
    }


    public Transaction deleteById(long id) {
        Transaction transaction = getById(id);
        if (transaction != null) {
            transactionRepository.deleteById(id);
        }
        return transaction;
    }

    public Transaction delete(Transaction transaction) {
        if (transaction != null) {
            transactionRepository.delete(transaction);
        }
        return transaction;
    }

    public void deleteAll() {
        transactionRepository.deleteAll();
    }


    public List<Transaction> getUserTransactions(long id) {
        return transactionRepository.findAll(id);
    }
}
