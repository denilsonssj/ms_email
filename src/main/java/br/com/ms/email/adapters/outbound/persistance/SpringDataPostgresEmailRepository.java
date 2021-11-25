package br.com.ms.email.adapters.outbound.persistance;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ms.email.adapters.outbound.persistance.entities.EmailEntity;

@Repository
public interface SpringDataPostgresEmailRepository
    extends JpaRepository<EmailEntity, UUID> {}
