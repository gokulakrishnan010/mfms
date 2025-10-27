package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(
        name = "CreateFundReq",
        description = "Request payload to create a new mutual fund script (symbol and name)."
)
public record CreateFundReq(

        @NotBlank
        @Schema(
                description = "Unique symbol identifier for the mutual fund (ticker-like).",
                example = "ALPHA"
        )
        String symbol,

        @NotBlank
        @Schema(
                description = "Human-readable name of the mutual fund.",
                example = "Alpha Growth Fund"
        )
        String name
) {}
