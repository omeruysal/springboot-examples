package com.example.demo;

import java.util.HashMap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongoDBApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringMongoDBApplication.class, args);
	}

	

		
	
}
