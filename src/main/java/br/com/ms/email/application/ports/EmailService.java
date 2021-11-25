package br.com.ms.email.application.ports;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ms.email.adapters.dtos.EmailDTO;
import br.com.ms.email.adapters.outbound.persistance.entities.EmailEntity;

public interface EmailService {
    
    EmailEntity sendEmail(EmailDTO emailDTO);
    Page<EmailEntity> findAll(Pageable pageable);
    Optional<EmailEntity> findById(UUID id);

}
