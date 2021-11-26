CREATE TABLE tb_email (
    id UUID UNIQUE NOT NULL,
    owner_ref VARCHAR(128) NOT NULL,
    email_from VARCHAR(128) NOT NULL,
    email_to VARCHAR(128) NOT NULL,
    subject VARCHAR(128) NOT NULL,
    text TEXT NOT NULL,
    send_date_email TIMESTAMP NOT NULL,
    status_email VARCHAR(32) NOT NULL
);

ALTER TABLE tb_email ADD CONSTRAINT pk_tb_email PRIMARY KEY (id);