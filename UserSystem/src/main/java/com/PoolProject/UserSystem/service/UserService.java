package com.PoolProject.UserSystem.service;

import com.PoolProject.UserSystem.model.User;

import java.util.List;

public interface UserService {
    User getUserByID (Long id);
    List<User> getAllUsers();
    void createUser(User user);
    User updateUserById(User user);
    void deleteUserById(Long id);
}
