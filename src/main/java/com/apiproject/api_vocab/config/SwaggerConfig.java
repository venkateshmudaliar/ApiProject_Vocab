package com.apiproject.api_vocab.config;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
    	return new Docket(DocumentationType.SWAGGER_2)
    			.select()
    			.apis(RequestHandlerSelectors.basePackage("com.apiproject.api_vocab.controller"))
    			//.paths(PathSelectors.regex("/cas.*"))
    			.paths(PathSelectors.any())
    			.build()
    			.pathMapping("/");
    }
    
    private ApiInfo metaData() {
    	return new ApiInfoBuilder()
                .title("Vocab and Quotes - Spring Boot API")
                .description("\"Spring Boot REST API for Vocab and Quotes\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Venkatesh Mudaliar", null,  "venkymudaliar@gmail.com" ))
                .build();
    }

}
