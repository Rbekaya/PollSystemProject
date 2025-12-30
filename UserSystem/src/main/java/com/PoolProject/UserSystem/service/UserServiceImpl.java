package com.PoolProject.UserSystem.service;

import com.PoolProject.UserSystem.model.User;
import com.PoolProject.UserSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByID(Long id) {
      return userRepository.getUserByID(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void createUser(User user) {
         userRepository.createUser(user);
    }

    @Override
    public User updateUserById(User user) {
        return userRepository.updateUserById(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }


}
