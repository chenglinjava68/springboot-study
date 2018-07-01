package com.ley.springboot.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.ley.springboot.annotation.configurationProperties.DatasourceProperties;

@SpringBootApplication
@EnableConfigurationProperties(value={DatasourceProperties.class})
@ComponentScan(basePackages={"com.ley.springboot.annotation"})
public class SpringbootAnnotationApplication {
	
	@Autowired
	private DatasourceProperties datasourceProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAnnotationApplication.class, args);
	}
	
	
	@Bean
	public DatasourceProperties dataSource(){
		System.out.println(datasourceProperties);
		return datasourceProperties;
	}
	
}
