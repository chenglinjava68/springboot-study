package com.ley.springboot.mybatis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ley.springboot.mybatis.utils.SwaggerUtils;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API配置
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Configuration extends WebMvcConfigurerAdapter{

	@SuppressWarnings("static-access")
	@Bean
	public Docket initDocket() {
		return new SwaggerUtils("Springboot Mybatis Api","1.0").initDocket();
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
