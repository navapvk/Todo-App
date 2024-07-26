package com.taskManagement.service;

import com.taskManagement.entity.Task;
import com.taskManagement.entity.User;
import com.taskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public List<Task> findByUserAndPriority(User user, String priority) {
        return taskRepository.findByUserAndPriority(user, priority);
    }

    public List<Task> findByUserAndCompleted(User user, boolean completed) {
        return taskRepository.findByUserAndCompleted(user, completed);
    }
}

