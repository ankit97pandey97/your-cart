package com.yourcart.controllers;

import com.yourcart.rest.RestUser;
import com.yourcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<RestUser> getAllUsers(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public RestUser getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/selected")
    public List<RestUser> getUsersByIds(@RequestBody List<Integer> ids){
        return userService.getUsersByIds(ids);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody RestUser tempUser){
        System.out.println("=========================");
            userService.postUser(tempUser);
    }

}
