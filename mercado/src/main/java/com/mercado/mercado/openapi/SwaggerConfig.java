package com.mercado.mercado.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI custonAPI(){
    return new OpenAPI().info(new Info().title("teste").version("1.0.0.0").license(new License().name("")));
    }
}