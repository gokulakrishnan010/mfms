package com.acme.mutualfund.config;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {
  @Bean OpenAPI api() { return new OpenAPI().info(new Info().title("Mutual Fund API").version("v1")); }
}
