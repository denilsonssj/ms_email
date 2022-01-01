# MS-EMAIL

## Description

Project of an email sending microservice developed in the microservice creation course using a hexagonal architecture of Michelli Brito's youtube channel.

## Tools and technologies

- [Java](https://www.java.com/)
- [JDK 11](https://openjdk.java.net/projects/jdk/11/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-jpa-and-spring-data)
- [Spring Validation](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-validation)
- [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-email)
- [RabbitMQ](https://www.rabbitmq.com/)
- [Spring AMQP](https://spring.io/projects/spring-amqp)
- [PostgreSQL](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-email)
- [Mapstruct](https://mapstruct.org/)

## Installing

Clone the repository. 

```
$ git clone https://github.com/denilsonssj/ms_email.git
```

## Getting started

First, make sure you use JDK version 11 or higher. You can download this version at this link.

### Install the dependencies

```
$ ./mvnw install clean -U -D skipTests
```

### Running the application

```
$ ./mvnw spring-boot:run
```

### Build the application

```
$ ./mvnw package
```

## Demo

The demo project can be viewed [here](https://denilsonssj-ms-email.herokuapp.com/).

## License

[MIT](https://github.com/denilsonssj/ms_email/blob/main/LICENSE)