package com.mmik.challenge.ne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class OmGwApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("OpenMovieAPIGateway")
				.apiInfo(apiInfo())
				.enable(true)
				.select()
				.paths(regex("/movies.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Open Movie API Gateway")
				.description("Open Movie API Gateway")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/mehdimahmoud/omgw/LICENSE")
				.version("1.0")
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(OmGwApplication.class, args);
	}
}
