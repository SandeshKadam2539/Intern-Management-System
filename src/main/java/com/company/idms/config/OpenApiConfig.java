package com.company.idms.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI idmsOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("IDMS - Intern Data Management System API")
                .description("APIs to manage interns and batches")
                .version("1.0.0")
                .contact(new Contact().name("Your Name").email("you@example.com"))
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
            )
            .externalDocs(new ExternalDocumentation().description("Project Docs").url("https://example.com"));
    }
}
