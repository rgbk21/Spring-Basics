package com.example.rgbk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class AppTests {

	// Note how we can autowire beans in this Test class as well

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {

		System.out.println();
	}

	@Test
	public void whenContextIsLoaded_thenNoExceptions(){
		System.out.println();
	}

}
