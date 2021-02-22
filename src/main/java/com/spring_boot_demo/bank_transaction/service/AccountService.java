package com.spring_boot_demo.bank_transaction.service;

import com.spring_boot_demo.bank_transaction.model.Account;
import com.spring_boot_demo.bank_transaction.model.Transaction;
import com.spring_boot_demo.bank_transaction.repository.AccountRepository;
import com.spring_boot_demo.bank_transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService  {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void makeTransaction(long fromAccountId, int transactionAmount)  {
        Transaction transaction = new Transaction();
        transactionRepository.save(transaction);
        Account account = accountRepository.findById(1L);
        account.setBalance(account.getBalance() - transactionAmount);
        accountRepository.save(account);
    }

    public void transfer(long accountId, long otherAccountId, double balance) {

        Account account = accountRepository.getById(accountId);
        Account otherAccount = accountRepository.getById(otherAccountId);

        account.setBalance(account.getBalance() - balance);

        otherAccount.setBalance(otherAccount.getBalance()  + balance);


        accountRepository.update(account);
        accountRepository.update(otherAccount);


    }

}
