package com.eta.ExpenseTrackerApp.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface EmailService {
    public void sendEmail(String to,String subject,String message);
    public void sendEmailWithHtmlContents(String to,String subject,String htmlContent);
    public void sendEmailWithAttachments(String to, String subject, String message, File file);
}
