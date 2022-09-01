package com.assignment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EntityScan("com.assignment.api.entities")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(getApiInfo())
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.assignment.api.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Api Project")
				.description(
						"This API is to be used for opening a new “current account” of already existing\n" + 
						"customers")
				.version("1.0.0").build();
	}

}
