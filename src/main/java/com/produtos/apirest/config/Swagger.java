package com.produtos.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ApiIgnore 
@RestController
public class Swagger {
	// http://localhost:8080/swagger-ui/index.html
		@Bean
		public Docket swaggerEditoraApi() {
			return new Docket(DocumentationType.SWAGGER_2)
		            .select()
		            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
		            .paths(PathSelectors.any())
		            .build();
			
			

		}
}
