package com.taskManagement.controller;

import com.taskManagement.entity.Task;
import com.taskManagement.entity.User;
import com.taskManagement.service.TaskService;
import com.taskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        task.setUser(user);
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return ResponseEntity.ok(taskService.findByUser(user));
    }


}

