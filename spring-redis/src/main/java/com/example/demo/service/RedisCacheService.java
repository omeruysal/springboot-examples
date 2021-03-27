package com.example.demo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

	@Cacheable(cacheNames = "mySpecialCache")
	public String doSomething() throws InterruptedException {
		Thread.sleep(5L);

		return "Method calisiyor.";
	}

	@CacheEvict(cacheNames = "mySpecialCache")
	public void clearCache() {
		System.out.println("cache temizledi");
	}

}
