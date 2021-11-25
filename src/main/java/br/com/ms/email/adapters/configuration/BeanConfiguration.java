package br.com.ms.email.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.ms.email.EmailApplication;
import br.com.ms.email.application.ports.EmailRepositoryPort;
import br.com.ms.email.application.ports.SendEmailServicePort;
import br.com.ms.email.application.services.EmailServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = EmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(
        EmailRepositoryPort emailRepositoryPort,
        SendEmailServicePort sendEmailServicePort) {
        return new EmailServiceImpl(emailRepositoryPort, sendEmailServicePort);
    }

}
