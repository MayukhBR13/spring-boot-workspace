package com.springtesting.SpringApplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringtestingApplication {

	private Calculator calculator=new Calculator();
	@Test
	void contextLoads() {
		
	}
	@Test
	void testSum() {
		int expectedRes=60;
		int actualResult=calculator.sum(10, 20, 30);
		
		assertThat(actualResult).isEqualTo(expectedRes);
				
	}
}
