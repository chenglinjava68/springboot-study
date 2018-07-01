package com.ley.springboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.ley.springboot.kafka"})
public class SpringbootKafkaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaApplication.class, args);
	}
}
