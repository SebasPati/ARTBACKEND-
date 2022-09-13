package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.UserDTO;
import com.challengerFinal.arte.dtos.UserRegister;
import com.challengerFinal.arte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public ResponseEntity<Object> registerUser(@RequestBody UserRegister user){
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

}
