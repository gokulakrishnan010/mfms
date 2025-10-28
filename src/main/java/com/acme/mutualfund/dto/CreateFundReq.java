package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(
        name = "CreateFundReq",
        description = "Request payload to create a new mutual fund script (symbol and name)."
)
public record CreateFundReq(

        @NotBlank
        @Pattern(regexp = "^[A-Z]{3,10}$")
        @Schema(description = "Unique symbol identifier for the mutual fund (ticker-like, 3–10 uppercase letters).",
                example = "ALPHA")
        String symbol,

        @NotBlank
        @Schema(description = "Human-readable name of the mutual fund.", example = "Alpha Growth Fund")
        String name
) {}
