package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddressDTO;
import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.UserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user/v1")
@Api(value = "User API documentation / value of @Api")
public class UserController {

	Map<Integer, UserDTO> userService;
	
			
	
	@PostConstruct
	void init(){

		AddressDTO address1 = AddressDTO.builder().country("Turkey").city("Istanbul").neighborhood("Sisli").doorNo("50").build();
		AddressDTO address2 = AddressDTO.builder().country("England").city("London").neighborhood("Hoxio").doorNo("720/A").build();
		AddressDTO address3 = AddressDTO.builder().country("Portugal").city("Lisboa").neighborhood("Barrio Alto").doorNo("999").build();

		
		

		CompanyDTO company = CompanyDTO.builder().companyName("Netas").category("telecommunication").build();
		
		UserDTO user1 =  UserDTO.builder().id(1).name("Omer").username("omer123").lastname("uysal").address(address1).company(company).build();
		UserDTO user2 =  UserDTO.builder().id(2).name("Ismail").username("iso").lastname("Taskiran").address(address2).company(company).build();
		UserDTO user3 =  UserDTO.builder().id(3).name("Irem").username("irem96").lastname("Ceyda").address(address3).company(company).build();
		
		UserDTO user4 =  UserDTO.builder().id(4).name("Ahmet").username("ahmet111").lastname("Uysal").build();
		UserDTO user5 =  UserDTO.builder().id(5).name("Ozmen").username("ozmen-999").lastname("Oge").build();
		
		userService = new HashMap<Integer, UserDTO>();
		userService.put(user1.getId(), user1);
		userService.put(user2.getId(), user2);
		userService.put(user3.getId(), user3);
		userService.put(user4.getId(), user4);
		userService.put(user5.getId(), user5);
		

		company.setUsers(userService);

		
	}
	
	@GetMapping("/getAll")
	@ApiOperation(value= "Get all users / value of @ApiOperation", notes="This method returns ResponseEntity<?> / notes of @ApiOperation")
	public Map<Integer,UserDTO> getAll() {
		System.out.println("geldi");
		return userService;
	}
	
	
	@GetMapping("/getById/{id}")
	@ApiOperation(value= "Get user object by Id / value of @ApiOperation", notes="This method returns ResponseEntity<?> / notes of @ApiOperation")
	public UserDTO getById(@PathVariable ("id") Integer id) {
		System.out.println(" id is "+ id);
		return userService.get(id);
	}
	
	@PostMapping()
	@ApiOperation(value= "Save new user object / value of @ApiOperation", notes="This method returns ResponseEntity<?> / notes of @ApiOperation")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user){
		
		userService.put(user.getId(),user);
		
		return ResponseEntity.ok(user);
	}
	
	

}
