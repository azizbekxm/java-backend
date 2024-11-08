package com.epam.jmp.event.service.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.epam.jmp.event.service")
@EntityScan("com.epam.jmp.event.service.dto")
@EnableMongoRepositories(basePackages = "com.epam.jmp.event.service.impl.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

