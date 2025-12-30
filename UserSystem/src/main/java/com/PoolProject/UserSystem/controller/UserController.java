package com.PoolProject.UserSystem.controller;

import com.PoolProject.UserSystem.model.User;
import com.PoolProject.UserSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getUserById (@PathVariable Long id){
        return userService.getUserByID(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers (){
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public void createNewUser (@RequestBody User user){
         userService.createUser(user);
    }

    @PutMapping("/update")
    public User updateUserbyId(@RequestBody User user){
       return userService.updateUserById(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

}
