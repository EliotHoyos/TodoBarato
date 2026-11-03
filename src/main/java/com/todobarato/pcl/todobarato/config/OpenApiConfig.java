package com.todobarato.pcl.todobarato.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema Todo Barato")
                        .version("1.0")
                        .description("Documentación de la API Rest Todo Barato S.A.C")
                        .contact(new Contact()
                                .name("Todo Barato")
                                .email("todobarato@gmail.com")));
    }

}
