package br.com.ms.email.adapters.outbound.persistance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.ms.email.adapters.mapper.EmailMapper;
import br.com.ms.email.adapters.outbound.persistance.entities.EmailEntity;
import br.com.ms.email.application.domain.Email;
import br.com.ms.email.application.domain.PageInfo;
import br.com.ms.email.application.ports.EmailRepositoryPort;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepositoryPort {

    private final SpringDataPostgresEmailRepository emailRepository;
    private final EmailMapper emailMapper;

    @Autowired
    public PostgresEmailRepository(
        SpringDataPostgresEmailRepository emailRepository) {
        this.emailRepository = emailRepository;
        this.emailMapper = EmailMapper.INSTANCE;
    }

    @Override
    public Email save(Email email) {
        EmailEntity emailEntitySaved = this.emailRepository
            .save(this.emailMapper.toEntity(email));
        return this.emailMapper.toEmail(emailEntitySaved);
    }

    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(
            pageInfo.getPageNumber(), pageInfo.getPageSize());
        return this.emailRepository.findAll(pageable).stream()
            .map(this.emailMapper::toEmail)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Email> findById(UUID id) {
        Optional<EmailEntity> emailEntity = this.emailRepository.findById(id);
        if (emailEntity.isPresent()) {
            return Optional.of(this.emailMapper.toEmail(emailEntity.get()));
        } else {
            return Optional.empty();
        }
    }

}
