package com.learn.usermanagement.Forogotpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final String fromEmail;
    private final String subjectPasswordReset;
    private final String passwordResetTemplate;

    @Autowired
    public EmailService(
            JavaMailSender javaMailSender,
            @Value("${email.from}") String fromEmail,
            @Value("${email.subject.passwordReset}") String subjectPasswordReset,
            @Value("${email.passwordResetTemplate}") String passwordResetTemplate
    ) {
        this.javaMailSender = javaMailSender;
        this.fromEmail = fromEmail;
        this.subjectPasswordReset = subjectPasswordReset;
        this.passwordResetTemplate = passwordResetTemplate;
    }

    public void sendPasswordResetEmail(String toEmail, String resetToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setFrom(fromEmail);
        message.setSubject(subjectPasswordReset);
        message.setText(passwordResetTemplate.replace("{resetUrl}", generateResetUrl(resetToken)));

        try {
            javaMailSender.send(message);
        } catch (MailException ex) {
            // Handle email sending exception
            ex.printStackTrace();
        }
    }

    private String generateResetUrl(String resetToken) {
        // Implement the logic to generate the reset URL (e.g., http://your-app-url/reset-password?token=resetToken)
        return "http://your-app-url/reset-password?token=" + resetToken;
    }
}
