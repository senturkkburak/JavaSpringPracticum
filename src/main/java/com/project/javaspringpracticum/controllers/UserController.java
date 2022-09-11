package com.project.javaspringpracticum.controllers;
import com.project.javaspringpracticum.entities.User;
import com.project.javaspringpracticum.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<User> getAllUsers(){

        return userService.findAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
    return userService.getOneUser(userId);
    }
}
