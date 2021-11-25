package br.com.ms.email.application.ports;

import br.com.ms.email.application.domain.Email;

public interface SendEmailServicePort {

    void sendEmailSmtp(Email email);

}
