package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "EnrollReq",
        description = "Request payload to register a new user account in the Mutual Fund Management System."
)
public record EnrollReq(

        @NotBlank
        @Schema(
                description = "Unique username for the new account.",
                example = "user1"
        )
        String username,

        @NotBlank
        @Size(min = 8, max = 120)
        @Schema(
                description = "User password (minimum 8 characters).",
                example = "s3cretP@ss"
        )
        String password
) {}

