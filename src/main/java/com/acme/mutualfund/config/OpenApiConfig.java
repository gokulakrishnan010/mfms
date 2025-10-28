package com.acme.mutualfund.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        var basic = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("basic");

        return new OpenAPI()
                .info(new Info()
                        .title("MFMS – Mutual Fund Management API")
                        .version("v1")
                        .description("""
                                REST APIs for enrollment, admin fund/NAV ops, and user trades/portfolio.
                                All endpoints (except /auth/enroll, and Swagger docs) require Basic Auth.
                                """))
                .components(new Components().addSecuritySchemes("basicAuth", basic))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
    }
}
