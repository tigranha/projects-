package com.spring_boot_demo.bank_transaction.repository;

import com.spring_boot_demo.bank_transaction.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findById(long id);
    Account getById(long accountId);
    void update(Account account);
}