package com.project.logmanagementutilitytool.controllers;

import com.project.logmanagementutilitytool.Service.UserService;
import com.project.logmanagementutilitytool.entity.UserEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

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
    @PutMapping("/modify-roles/{username}/{Action}/{Rolename}")
    public ResponseEntity<?> modifyRoles(@PathVariable String username,@PathVariable String Action ,@PathVariable  String Rolename) {
        return userService.modifyRoles(username,Action,Rolename);
    }

    @GetMapping("Login")
    public ResponseEntity<?> getUser(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic")) {
            // Extract and decode the Base64 encoded credentials
            String base64Credentials = authHeader.substring("Basic".length()).trim();
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);

            // Split the credentials into username and password
            String[] values = credentials.split(":", 2);
            String username = values[0];
            String password = values[1];

            // Use the username and password as needed
            return userService.getUser(username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
        }
    }}