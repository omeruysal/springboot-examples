package com.example.demo.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.UserDTO;


@FeignClient(url="http://localhost:8080/",name="USER-CLIENT")
public interface UserClient {
	
	@GetMapping("user/v1/getAll")
	public String getAll();
	
	@GetMapping("user/v1/getById/{id}")
	public UserDTO getById(@PathVariable ("id") Integer id);
	
	
	@PostMapping()
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user);

}
