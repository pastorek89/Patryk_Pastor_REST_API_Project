package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Daily mail: Tasks";

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(),SUBJECT,
                "Currently in database you got " + size + chooseWriteOutOption()));
    }

    public String chooseWriteOutOption() {
        long tasksQuantity = taskRepository.count();
        return (tasksQuantity == 0 || tasksQuantity > 1) ? " tasks." : " task.";
    }
}
