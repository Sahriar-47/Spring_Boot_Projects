package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String recipientEmail;
    private String subject;
    private String msgBody;
    private String attachment;

    public EmailDetails(String recipientEmail, String subject, String msgBody) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.msgBody = msgBody;
    }
}
