package com.spring_boot_demo.bank_transaction.service;

import com.spring_boot_demo.bank_transaction.model.Transaction;
import com.spring_boot_demo.bank_transaction.model.User;
import com.spring_boot_demo.bank_transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user, long id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            User updatedUser = userById.get();

            if (user.getFirstName() != null) {
                updatedUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                updatedUser.setLastName(user.getLastName());
            }
            if (user.getAccount() != null){
                updatedUser.setAccount(user.getAccount());
            }
            if (user.getRole() != null){
                updatedUser.setRole(user.getRole());
            }


            userRepository.save(updatedUser);
        }
    }


    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Iterable<User> all = userRepository.findAll();
        for (User user : all) {
            list.add(user);
        }
        return list;
    }


    public User deleteById(long id) {
        User user = getById(id);
        if (user != null) {
            userRepository.deleteById(id);
        }
        return user;
    }

    public User delete(User user) {
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }


}
