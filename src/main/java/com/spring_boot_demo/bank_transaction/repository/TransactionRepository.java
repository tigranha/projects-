package com.spring_boot_demo.bank_transaction.repository;

import com.spring_boot_demo.bank_transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    List<Transaction> findAll(long id);
}
