package com.example.service;


import com.example.entity.UserEntitySrujan;
import com.example.repository.UserRepositorySrujan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceSrujan {
    @Autowired
    private UserRepositorySrujan loginRepository;

    public List<UserEntitySrujan> findAllUsers() {
        return loginRepository.findAll();
    }

    public void registerUser(UserEntitySrujan user) {
        loginRepository.save(user);
    }
}
