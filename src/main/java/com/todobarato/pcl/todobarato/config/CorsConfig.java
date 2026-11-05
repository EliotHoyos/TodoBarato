package com.todobarato.pcl.todobarato.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") //Aplica la configuracion a todos los endpoints de la API
                .allowedOrigins(
                    "http://localhost:5173", //Origen de desarrollo de React/Vitae
                    "http://127.0.0.1:5173"
                )
                .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS") //Métodos HTTP
                .allowedHeaders("*") //Permite todos los encabezados (Content-Type, Autorization, etc)
                .allowCredentials(true) //Permite el envio de cookies y encabezados de autenticación
                .maxAge(3600); //Guarda en caché la respuesta pre-flight (OPTIONS) por 1 hora
    }

}
