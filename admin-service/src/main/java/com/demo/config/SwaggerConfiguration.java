package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket mySwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.demo"))
				.build()
				.apiInfo(apiInfo())
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("This is my first springboot rest")
				.description("Some description is here")
				.version("5.4")
				.contact(new Contact("Test", "http://example.com", "test@gmail.com"))
				.build()
				;
	}
}
