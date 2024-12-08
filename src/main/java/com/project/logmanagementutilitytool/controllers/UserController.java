package com.project.logmanagementutilitytool.controllers;

import com.project.logmanagementutilitytool.Service.UserService;
import com.project.logmanagementutilitytool.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserEntity userEntity) {
        return userService.addUser(userEntity);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        return userService.getUser(username);
    }
}