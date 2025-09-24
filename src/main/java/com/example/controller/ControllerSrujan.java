package com.example.controller;


import com.example.entity.UserEntitySrujan;
import com.example.service.UserServiceSrujan;
import org.hibernate.query.UnknownSqlResultSetMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/c1")
public class ControllerSrujan {
    @Autowired
    UserServiceSrujan loginService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntitySrujan>> allUsersSrujan(){
        List<UserEntitySrujan> l1=new ArrayList<>();
        l1=loginService.findAllUsers();
        return ResponseEntity.ok().body(l1);
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUserSrujan(@RequestBody UserEntitySrujan userEntity)
    {
        loginService.registerUser(userEntity);
        return new ResponseEntity<>("Created Successfully",HttpStatus.OK);

    }

}

