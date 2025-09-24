package com.example.controller;

import com.example.entity.UserEntitySrujan;
import com.example.service.UserServiceSrujan;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ControllerSrujanTest {

    @Autowired
    private UserServiceSrujan userService;

    @Autowired
    private ControllerSrujan controller;

    @Test
    void testAddUserController() {
        UserEntitySrujan user = new UserEntitySrujan();
        user.setUsername("TestUser");
        user.setPassword("Pass@123");

        // Call controller
        ResponseEntity<String> response = controller.addUserSrujan(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Created Successfully", response.getBody());

        List<UserEntitySrujan> allUsers = userService.findAllUsers();
        assertEquals(1, allUsers.size());
        assertEquals("TestUser", allUsers.get(0).getUsername());
    }

    @Test
    void testGetAllUsersController() {
        UserEntitySrujan user1 = new UserEntitySrujan();
        user1.setUsername("Srujan");
        user1.setPassword("Pass@123");

        UserEntitySrujan user2 = new UserEntitySrujan();
        user2.setUsername("TestUser1");
        user2.setPassword("Pass@123");

        userService.registerUser(user1);
        userService.registerUser(user2);

        // Call controller
        ResponseEntity<List<UserEntitySrujan>> response = controller.allUsersSrujan();
        List<UserEntitySrujan> allUsers = response.getBody();

        assertNotNull(allUsers);
        assertEquals(2, allUsers.size());
        assertTrue(allUsers.stream().anyMatch(u -> u.getUsername().equals("Srujan")));
        assertTrue(allUsers.stream().anyMatch(u -> u.getUsername().equals("TestUser1")));
    }
}
