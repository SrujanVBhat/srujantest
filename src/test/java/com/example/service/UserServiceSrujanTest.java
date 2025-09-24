package com.example.service;

import com.example.entity.UserEntitySrujan;
import com.example.repository.UserRepositorySrujan;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceSrujanTest {

    @Mock
    private UserRepositorySrujan userRepository;

    @InjectMocks
    private UserServiceSrujan userService;

    public UserServiceSrujanTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllUsers() {
        when(userRepository.findAll()).thenReturn(
                Arrays.asList(new UserEntitySrujan(1L, "Srujan", "Pass@123"))
        );

        List<UserEntitySrujan> users = userService.findAllUsers();

        assertEquals(1, users.size());
        assertEquals("Srujan", users.get(0).getUsername());
    }

    @Test
    void testRegisterUser() {
        UserEntitySrujan user = new UserEntitySrujan(1L, "User1", "Pass@123");
        userService.registerUser(user);

        verify(userRepository, times(1)).save(user);
    }
}
