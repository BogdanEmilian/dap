package com.endava.tmd.dap.controller;

import com.endava.tmd.dap.entity.User;
import com.endava.tmd.dap.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //Create a new User
    @PostMapping(path = "/createUser/{username}/{password}/{email}")
    public void createUser(@PathVariable String username, @PathVariable String email, @PathVariable String password){
        userService.addUser(new User(username, password, email, null));
    }

    //Get all Users
    @GetMapping(path = "/users")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    //Get a specific user
    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.findUser(id);
    }

    //Delete a user
    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
