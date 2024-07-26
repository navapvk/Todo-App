package com.taskManagement.controller;

import com.taskManagement.entity.User;
import com.taskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/profile")
    public ResponseEntity<User> profile(Principal principal) {
        return ResponseEntity.ok(userService.findByUsername(principal.getName()));
    }
}
