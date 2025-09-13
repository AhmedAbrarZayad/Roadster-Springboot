package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiConfig() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Local Development Server");

        // Add more servers here when you deploy to different environments
        // Server productionServer = new Server();
        // productionServer.setUrl("https://your-production-url.com");
        // productionServer.setDescription("Production Server");

        Contact contact = new Contact();
        contact.setName("Roadster API Support");
        contact.setEmail("support@roadster.com");

        return new OpenAPI()
            .info(new Info()
                .title("Roadster Backend API")
                .version("1.0.0")
                .description("API documentation for Roadster Backend Services including real-time location tracking, driver management, and police station information.")
                .contact(contact))
            .servers(List.of(localServer));
    }
}

