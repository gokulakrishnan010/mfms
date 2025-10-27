package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(name = "FundDto", description = "Represents a mutual fund and its latest NAV.")
public record FundDto(
        @Schema(
                description = "Unique fund symbol identifier (ticker-like).",
                example = "ALPHA"
        )
        String symbol,

        @Schema(
                description = "Display name of the mutual fund.",
                example = "Alpha Growth Fund"
        )
        String name,

        @Schema(
                description = "Today's Net Asset Value (NAV) per unit.",
                example = "51.245600"
        )
        BigDecimal todayNav
) {}

