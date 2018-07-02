package com.ley.springboot.mybatis.utils;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerUtils {
	
	public static String title;
	
	private static String version;
	
	
	public SwaggerUtils(String title,String version) {
		SwaggerUtils.title=title;
		SwaggerUtils.version=version;
	}

	private static ApiInfo apiInfo() {
		return (new ApiInfoBuilder()).title(SwaggerUtils.title).version(SwaggerUtils.version).build();
	}

	public static Docket initDocket() {
		return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
}