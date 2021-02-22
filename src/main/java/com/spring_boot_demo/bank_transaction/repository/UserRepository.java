package com.spring_boot_demo.bank_transaction.repository;


import com.spring_boot_demo.bank_transaction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
