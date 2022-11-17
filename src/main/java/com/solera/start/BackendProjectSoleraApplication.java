package com.solera.start;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BackendProjectSoleraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendProjectSoleraApplication.class, args);
	}

}