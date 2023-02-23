package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.springboot")
@EnableJpaRepositories("com.springboot")
public class App {
		public static void main(String[] args) {
			SpringApplication.run(App.class, args);
		}
}
