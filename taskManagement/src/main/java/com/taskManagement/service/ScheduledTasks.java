package com.taskManagement.service;

import com.taskManagement.entity.Task;
import com.taskManagement.repository.TaskRepository;
import com.taskManagement.utility.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduledTasks {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?") // Every day at 9 AM
    public void sendDueDateNotifications() {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getDueDate().isEqual(LocalDate.now().plusDays(1))) {
                emailService.sendNotificationEmail(task.getUser().getEmail(),
                        "Task Due Tomorrow", "Your task '" + task.getTitle() + "' is due tomorrow.");
            }
        }
    }
}

