package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Notification;
import com.example.demo.model.Product;
import com.example.demo.producer.NotificationProducer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/products/v1")
@Api(value = "My Product API documentation / value of @Api")
public class ProductController {
	
	List<Product> productService = new ArrayList<Product>();
	
	@Autowired
	public NotificationProducer notificationProducer;
	
	@PostMapping("/user")
	@ApiOperation(value= "Crate new Product object / value of @ApiOperation", notes="This method returns ResponseEntity<?> / notes of @ApiOperation")
	public ResponseEntity<?> createProduct(@RequestBody Product product){
		
		productService.add(product);
		Notification notification = new Notification(UUID.randomUUID().toString(), new Date(), false, "The product created which has the ID "+product.getId(), product.getDescripton());
		
		notificationProducer.sendToQueue(notification);
		
		return ResponseEntity.ok(product);
	}
	
	@GetMapping
	@ApiOperation(value= "Get all products from service")
	public ResponseEntity<?> getAll(){
		
		if(productService.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.ok(productService);
	}
	
	
//	@GetMapping
//	@ApiOperation(value= "testing")
//	public ResponseEntity<?> welcome1(){
//		
//		return ResponseEntity.ok("welcome");
//	}

}
