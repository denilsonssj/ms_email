package br.com.ms.email.adapters.outbound.persistance.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

import br.com.ms.email.application.domain.enums.StatusEmail;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "owner_ref")
    private String ownerRef;

    @Column(name = "email_from")
    private String emailFrom;

    @Column(name = "email_to")
    private String emailTo;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "send_date_email")
    private LocalDateTime sendDateEmail;

    @Column(name = "status_email")
    @Enumerated(value = EnumType.STRING)
    private StatusEmail statusEmail;

}
