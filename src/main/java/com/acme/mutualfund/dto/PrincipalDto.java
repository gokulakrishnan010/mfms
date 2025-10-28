package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Authenticated principal details")
public record PrincipalDto(
        @Schema(example = "gokul") String username,
        @Schema(description = "Granted authorities") List<String> roles
) {}