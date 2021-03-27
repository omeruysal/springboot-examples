package com.example.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@PostConstruct
	public void init() {
		System.out.println("calisti");
		User user1 = new User();
		user1.setUsername("First");
		user1.setLastname("User");
		
		userRepository.save(user1);
	}

	@GetMapping
	public String deneme() {
		return "welcome";
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));

	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable String id){
		return ResponseEntity.ok(userRepository.findById(id));
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	
	@GetMapping("/user/add")
	public ResponseEntity addByRest(@RequestParam("name") String username,@RequestParam("lastname") String lastname){
		System.out.println("username "+ username+ " lastname "+ lastname);
		
		RestTemplate restTemplate = new RestTemplate();
		
		User user = new User();
		user.setUsername(username);
		user.setLastname(lastname);
		
		ResponseEntity response = restTemplate.postForEntity("http://localhost:8080/user/v1/user", user, User.class);
		
		return response;
		
	}

}
