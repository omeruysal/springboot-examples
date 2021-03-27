package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user/v1")
@Api(value = "My User API documentation / value of @Api")
public class UserController {
	
	List<User> userService = new ArrayList();
	
	@PostConstruct
	public void init() { //bu method yerine constructorda kullanabilirdik fakat constructor esnasinda obje daha tam olarak yaratilmamistir bu yuzden problemle karsilaasabiliriz
		
		userService.add(new User(1L, "Omer", "Uysal", "Turkiye"));
		userService.add(new User(2L, "Ali", "Atmaca", "Almanya"));
		userService.add(new User(3L, "Ahmet", "Altun", "Belcika"));
		userService.add(new User(4L, "Nazim", "Sonmez", "Portekiz"));
		userService.add(new User(5L, "Ismail", "Uysal", "Turkiye"));
		
	}
	
	@PostMapping("/user")
	@ApiOperation(value= "Sve new user object / value of @ApiOperation", notes="This method returns ResponseEntity<?> / notes of @ApiOperation")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		user.setId(10L);
		System.out.println(user);
		userService.add(user);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value= "Get user by id  object / value of @ApiOperation", notes="This method returns ResponseEntity<?> / notes of @ApiOperation")
	public ResponseEntity<?> getAll(@PathVariable Integer id){
		
		User user;
		try {
			
			user =	userService.get(id);
			
		} catch (Exception e) {
			System.out.println(" not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
		}
		
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/user")
	@ApiOperation(value= "Get all user objects / value of @ApiOperation", notes="This method returns ResponseEntity<?> / notes of @ApiOperation")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.ok(userService);
	}

}
