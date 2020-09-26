package com.testForSpringBoot.Starter.swagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket swaggerConfig() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.testForSpringBoot"))
				.build()
				.apiInfo(apiDetails());
		
	}
	
	private ApiInfo apiDetails() {
		
		return new ApiInfo(
				
				"TEST FOR SPRING BOOT",
				"SAMPLE FOR LEARING",
				"1.0",
				"FREE TO USE",
				new springfox.documentation.service.Contact("SAUJIT GUPTA", "www.saujitgupta.com",
						"guptasaujit98@gmail.com"),
				"API LICENSE",
				"www.saujitgupta.com",
				Collections.emptyList());
	}

}
