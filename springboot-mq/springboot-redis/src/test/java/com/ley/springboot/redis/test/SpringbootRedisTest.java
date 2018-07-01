package com.ley.springboot.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.ley.springboot.redis.utils.RedisUtils;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages={"com.ley.springboot.redis"})
public class SpringbootRedisTest {

	@Autowired
	private RedisUtils redisUtils;
	
	@Test
	public void test(){
		redisUtils.set("key1", "value1");
		System.out.println(redisUtils.get("key1"));
	}
}
