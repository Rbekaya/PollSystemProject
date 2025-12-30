package PoolProjectPool.example.PollQuestionSystem.controller;

import PoolProjectPool.example.PollQuestionSystem.dto.InternalUser;
import PoolProjectPool.example.PollQuestionSystem.service.internalUserClient.InternalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/internalUser")
public class InternalUserController {

    @Autowired
    InternalUserService internalUserService;

    @GetMapping("/user/{id}")
    public InternalUser getUserById(@PathVariable Long id){
        return internalUserService.getInternalUserById(id);
    }

    @GetMapping("/user/all")
    public List<InternalUser> getAllUser(){
        return internalUserService.getAllInternalUser();
    }

}
