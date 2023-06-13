package com.example231.crud.service;

import com.example231.crud.model.Role;
import com.example231.crud.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    boolean addUser(User user);
    void removeUser(Long id);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByName(String name);
    List<Role> getAllRoles();

}
