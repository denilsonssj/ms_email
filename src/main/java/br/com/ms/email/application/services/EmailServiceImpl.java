package br.com.ms.email.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ms.email.application.domain.Email;
import br.com.ms.email.application.domain.PageInfo;
import br.com.ms.email.application.domain.enums.StatusEmail;
import br.com.ms.email.application.ports.EmailRepositoryPort;
import br.com.ms.email.application.ports.EmailServicePort;
import br.com.ms.email.application.ports.SendEmailServicePort;

public class EmailServiceImpl implements EmailServicePort {

    private final EmailRepositoryPort emailRepositoryPort;
    private final SendEmailServicePort sendEmailServicePort;

    public EmailServiceImpl(
        EmailRepositoryPort emailRepositoryPort,
        SendEmailServicePort sendEmailServicePort
    ) {
        this.emailRepositoryPort = emailRepositoryPort;
        this.sendEmailServicePort = sendEmailServicePort;
    }

    @Override
    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try {
            this.sendEmailServicePort.sendEmailSmtp(email);
            email.setStatusEmail(StatusEmail.SENT);
        } catch(Exception e) {
            email.setStatusEmail(StatusEmail.ERROR);
        }
        return this.save(email);
    }

    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        return this.emailRepositoryPort.findAll(pageInfo);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        return this.emailRepositoryPort.findById(emailId);
    }

    @Override
    public Email save(Email email) {
        return this.emailRepositoryPort.save(email);
    }

}
