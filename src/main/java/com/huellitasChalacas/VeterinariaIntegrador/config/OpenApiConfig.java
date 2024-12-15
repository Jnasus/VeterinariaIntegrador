/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jtorr
 */
@Configuration
public class OpenApiConfig {

    // Configuración global de OpenAPI
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Huellita Chalaca")
                        .version("1.0.0")
                        .description("Descripción detallada de mi API")
                        .termsOfService("https://ejemplo.com/terminos")
                        .contact(new Contact()
                                .name("Grupo 02")
                                .url("https://ejemplo.com/contacto")
                                .email("grupo02@mail.com"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }

    // Agrupación de APIs (si tienes múltiples grupos)
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("Admin")
                .packagesToScan("com.huellitasChalacas.VeterinariaIntegrador.adminController")
                .build();
    }

    @Bean
    public GroupedOpenApi privateApi() {
        return GroupedOpenApi.builder()
                .group("Private")
                .packagesToScan("com.huellitasChalacas.VeterinariaIntegrador.controller")
                .build();
    }
    // Puedes agregar más grupos según tus necesidades
}
