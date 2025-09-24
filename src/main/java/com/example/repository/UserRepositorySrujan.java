package com.example.repository;

import com.example.entity.UserEntitySrujan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorySrujan extends JpaRepository<UserEntitySrujan, Long> {
    UserEntitySrujan findByUsername(String username);
}
