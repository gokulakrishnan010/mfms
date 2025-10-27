package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "PrincipalDto",
        description = "Represents an authenticated user and their assigned roles."
)
public record PrincipalDto(

        @Schema(
                description = "Unique username of the authenticated user.",
                example = "user1"
        )
        String username,

        @Schema(
                description = "List of roles assigned to the user (e.g., ROLE_USER, ROLE_ADMIN).",
                example = "[\"ROLE_USER\"]"
        )
        List<String> roles
) {}