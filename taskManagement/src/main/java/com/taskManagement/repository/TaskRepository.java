package com.taskManagement.repository;

import com.taskManagement.entity.Task;
import com.taskManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByUserAndPriority(User user, String priority);
    List<Task> findByUserAndCompleted(User user, boolean completed);
}

