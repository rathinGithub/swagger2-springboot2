package com.techwithratz.initialzr.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final ApiInfo DEFAULT_API_INFO = 
			 new ApiInfoBuilder()
			.title("Baby Day Care Service")
			.description("This page lists all API's of Baby Day Care Management")
			.version("2.0")
			.contact(new Contact("Rathin Maheswaran", "https://www.youtube.com/channel/UC1L1TgZy8vSSsTXWF-zFyxQ", "rathin91@gmail.com"))
			.license("License 2.0")
			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
			.build();
	
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
			Arrays.asList("application/xml", "application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.techwithratz.initialzr"))
				.paths(PathSelectors.ant("/**"))
				.paths(PathSelectors.any())
				.build();
	}
}