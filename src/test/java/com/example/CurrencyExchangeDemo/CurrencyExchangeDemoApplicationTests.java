package com.example.CurrencyExchangeDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import main.CurrencyExchangeDemoApplication;

@SpringBootTest
@ContextConfiguration(classes = CurrencyExchangeDemoApplication.class)
class CurrencyExchangeDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Configuration
	static class Config {
	}

}
