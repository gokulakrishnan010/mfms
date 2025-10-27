package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(name = "NavDto", description = "Represents the Net Asset Value (NAV) of a mutual fund for a specific date.")
public record NavDto(

        @Schema(
                description = "Unique symbol of the mutual fund.",
                example = "ALPHA"
        )
        String symbol,

        @Schema(
                description = "Date for which the NAV is applicable, in ISO format (yyyy-MM-dd).",
                example = "2025-10-28"
        )
        String date,

        @Schema(
                description = "Net Asset Value (NAV) per unit for the given date.",
                example = "51.245600"
        )
        BigDecimal nav
) {}

