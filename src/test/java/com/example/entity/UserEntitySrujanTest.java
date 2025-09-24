package com.example.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserEntitySrujanTest {

    @Test
    void testNoArgsConstructorAndSetters() {
        UserEntitySrujan user = new UserEntitySrujan();
        user.setId(1L);
        user.setUsername("SrujanUser");
        user.setPassword("Password@123");

        assertEquals(1L, user.getId());
        assertEquals("SrujanUser", user.getUsername());
        assertEquals("Password@123", user.getPassword());
    }

    @Test
    void testAllArgsConstructor() {
        UserEntitySrujan user = new UserEntitySrujan(2L, "TestUser", "Pass@1234");

        assertEquals(2L, user.getId());
        assertEquals("TestUser", user.getUsername());
        assertEquals("Pass@1234", user.getPassword());
    }
}
