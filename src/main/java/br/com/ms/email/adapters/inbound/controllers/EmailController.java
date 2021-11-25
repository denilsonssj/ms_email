package br.com.ms.email.adapters.inbound.controllers;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms.email.adapters.dtos.EmailDTO;
import br.com.ms.email.adapters.mapper.EmailMapper;
import br.com.ms.email.application.domain.Email;
import br.com.ms.email.application.domain.PageInfo;
import br.com.ms.email.application.ports.EmailServicePort;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailServicePort emailServicePort;
    private final EmailMapper emailMapper;

    @Autowired
    public EmailController(EmailServicePort emailServicePort) {
        this.emailServicePort = emailServicePort;
        this.emailMapper = EmailMapper.INSTANCE;
    }

    @PostMapping("/send-email")
    public ResponseEntity<Email> sendEmail(@RequestBody EmailDTO emailDTO) {
        Email email = this.emailMapper.toEmail(emailDTO);
        return new ResponseEntity<>(
            this.emailServicePort.sendEmail(email),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<Email>> findAll(
        @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<Email> emails = this.emailServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<Email>(emails), HttpStatus.OK);
    }

}
