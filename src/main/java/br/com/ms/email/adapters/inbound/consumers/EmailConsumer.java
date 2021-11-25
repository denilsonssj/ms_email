package br.com.ms.email.adapters.inbound.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.ms.email.adapters.dtos.EmailDTO;
import br.com.ms.email.adapters.mapper.EmailMapper;
import br.com.ms.email.application.domain.Email;
import br.com.ms.email.application.ports.EmailServicePort;

@Component
public class EmailConsumer {

    private final EmailServicePort emailServicePort;
    private final EmailMapper emailMapper;

    @Autowired
    public EmailConsumer(EmailServicePort emailServicePort) {
        this.emailServicePort = emailServicePort;
        this.emailMapper = EmailMapper.INSTANCE;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        Email email = this.emailMapper.toEmail(emailDTO);
        this.emailServicePort.sendEmail(email);       
    }

}
