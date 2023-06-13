package com.example231.crud.controller;

import com.example231.crud.dto.UserDTO;
import com.example231.crud.mapper.UserMapper;
import com.example231.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class RestUsersController {
    private UserService userService;
    private UserDTO userDto;
    private UserMapper userMapper;

    @Autowired
    public RestUsersController(UserService userService, UserDTO userDto, UserMapper userMapper) {
        this.userService = userService;
        this.userDto = userDto;
        this.userMapper = userMapper;
    }

    @GetMapping("/getUser")
    public UserDTO getUser(Principal principal) {
        return userMapper.map(userService.getUserByName(principal.getName()));
    }

    @PostMapping("/register")
    public void addUser(@Valid @RequestBody UserDTO userDto) {
        userService.addUser(userMapper.map(userDto));
    }

}



