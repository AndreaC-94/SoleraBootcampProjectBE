package com.solera.group4.spring.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.solera.group4.spring.backend.repository.GroupRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication{
    
    @Autowired
    GroupRepository groupRepo;
    
    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

}