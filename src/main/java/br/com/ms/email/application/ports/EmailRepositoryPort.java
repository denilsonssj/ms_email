package br.com.ms.email.application.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.ms.email.application.domain.Email;
import br.com.ms.email.application.domain.PageInfo;

public interface EmailRepositoryPort {
    
    Email save(Email email);
    List<Email> findAll(PageInfo pageInfo);
    Optional<Email> findById(UUID id);

}
