package com.mmik.challenge.ne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by mmik on 21/02/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
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
}
