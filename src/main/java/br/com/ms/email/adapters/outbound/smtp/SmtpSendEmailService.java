package br.com.ms.email.adapters.outbound.smtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.ms.email.application.domain.Email;
import br.com.ms.email.application.ports.SendEmailServicePort;

@Service
public class SmtpSendEmailService implements SendEmailServicePort {

    private final JavaMailSender emailSender;

    @Autowired
    public SmtpSendEmailService(final JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendEmailSmtp(Email email) throws MailException {
       SimpleMailMessage message = new SimpleMailMessage();
       message.setFrom(email.getEmailFrom());
       message.setTo(email.getEmailTo());
       message.setSubject(email.getSubject());
       message.setText(email.getText());
       this.emailSender.send(message);
    }
    
}
