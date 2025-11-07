package com.example.scheduler;

import com.example.dto.EmailDetails;
import com.example.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class EmailScheduler {
    private static final Logger log = LoggerFactory.getLogger(EmailScheduler.class);

    private final EmailService emailService;
    @Autowired
    public EmailScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(fixedDelay = 5000,  initialDelay = 5000)
    public void sendSimpleMail() {
        log.info("Sending Simple Mail...");
        EmailDetails emailDetails =
                new EmailDetails("tarek1237er@gmail.com", "test subject", "test message" );
        emailService.sendSimpleMail(emailDetails);
        log.info("Simple Mail sent successfully");
    }
}
