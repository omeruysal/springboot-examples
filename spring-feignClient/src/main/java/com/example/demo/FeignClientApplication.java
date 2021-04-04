package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(FeignClientApplication.class, args);
	}


}
