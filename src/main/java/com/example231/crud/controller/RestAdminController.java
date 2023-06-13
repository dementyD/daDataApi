package com.example231.crud.controller;

import com.example231.crud.dto.UserDTO;
import com.example231.crud.mapper.UserMapper;
import com.example231.crud.repositories.RoleRepository;
import com.example231.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class RestAdminController {
    private UserService userService;
    private RoleRepository roleRepository;
    private UserDTO userDto;
    private UserMapper userMapper;

    @Autowired
    public RestAdminController(UserService userService, RoleRepository roleRepository,
                               UserDTO userDto, UserMapper userMapper) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userDto = userDto;
        this.userMapper = userMapper;
    }

    @GetMapping("/adminGetAll")
    public List<UserDTO> getAllUser() {
        return userMapper.mapList(userService.findAllUsers());
    }

    @GetMapping("/admin/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userMapper.map(userService.getUserById(id));
    }

    @GetMapping("/getUserSession")
    public UserDTO getUserSession(Principal principal) {
        return userMapper.map(userService.getUserByName(principal.getName()));
    }

    @PostMapping("/admin")
    public void newUser(@Valid @RequestBody UserDTO userDto) {
        userService.addUser(userMapper.map(userDto));
    }

    @PutMapping("/admin/edit")
    public void editUser(@Valid @RequestBody UserDTO userDto) {
        userService.updateUser(userMapper.editMapUser(userDto));
    }

    @DeleteMapping("/admin/delete")
    public void deleteUser(@RequestBody UserDTO userDto) {
        userService.removeUser(userDto.getId());
    }

}
