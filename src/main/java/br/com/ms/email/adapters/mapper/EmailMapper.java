package br.com.ms.email.adapters.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.ms.email.adapters.dtos.EmailDTO;
import br.com.ms.email.adapters.outbound.persistance.entities.EmailEntity;
import br.com.ms.email.application.domain.Email;

@Mapper
public interface EmailMapper {
    
    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    Email toEmail(EmailDTO emailDTO);

    Email toEmail(EmailEntity emailEntity);

    EmailEntity toEntity(Email email);

}
