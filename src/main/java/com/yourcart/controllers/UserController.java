package com.yourcart.controllers;

import com.yourcart.rest.RestUser;
import com.yourcart.service.UserServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceCustom userService;


    @GetMapping("/all")
    public List<RestUser> getAllUsers(){
        System.out.println("fghjkl;");
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

    @PostMapping("/addUser")
    public void addUser(@RequestBody RestUser tempUser){
            userService.postUser(tempUser);
    }

}
