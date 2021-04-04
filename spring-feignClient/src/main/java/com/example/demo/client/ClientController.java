package com.example.demo.client;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.*;

@RestController
@RequestMapping("/from/client")
public class ClientController {
	
	@Autowired
	UserClient userClient;
	
	@GetMapping()
	public String getAll(){
		
		return userClient.getAll();
		
	}
	
	@GetMapping("/{id}")
	public UserDTO getAll(Integer id){
		
		return userClient.getById(id);
		
	}
	
	
}
