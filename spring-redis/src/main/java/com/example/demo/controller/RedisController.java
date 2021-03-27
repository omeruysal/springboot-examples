package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RedisCacheService;

@RestController
public class RedisController {

	@Autowired
	RedisCacheService redisCacheService;

	private int sayac = 0;

	@GetMapping
	public String cacheControl() throws InterruptedException {
		if (sayac == 5) {
			redisCacheService.clearCache();
			sayac = 0;
		}
		sayac++;
		return redisCacheService.doSomething();
	}
}
