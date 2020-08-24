package com.epam.springepam2020.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    private final String moduleName;
    private final String apiVersion;

    public SwaggerConfiguration(
            @Value("${module-name}") String moduleName,
            @Value("${api-version}") String apiVersion
    ) {
        this.moduleName = moduleName;
        this.apiVersion = apiVersion;
    }

    @Bean
    public OpenAPI customOpenApi() {
        String securitySchema = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchema))
                .components(
                        new Components()
                        .addSecuritySchemes(securitySchema,
                                new SecurityScheme()
                        .name(securitySchema)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        )
                )
                .info(new Info().version(apiVersion));
    }

}
