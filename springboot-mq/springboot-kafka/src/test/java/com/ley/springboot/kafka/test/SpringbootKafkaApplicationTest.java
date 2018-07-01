package com.ley.springboot.kafka.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages={"com.ley.springboot.kafka"})
public class SpringbootKafkaApplicationTest {

	@Test
	public void contextLoads() {
	}
}
