package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(
        name = "TradeDto",
        description = "Represents a trade transaction (buy or redeem) performed by a user."
)
public record TradeDto(

        @Schema(
                description = "Unique identifier of the trade transaction.",
                example = "1001"
        )
        Long id,

        @Schema(
                description = "Type of trade operation — BUY or REDEEM.",
                example = "BUY"
        )
        String type,

        @Schema(
                description = "Symbol of the mutual fund involved in the trade.",
                example = "ALPHA"
        )
        String symbol,

        @Schema(
                description = "Number of units bought or redeemed.",
                example = "10.00000000"
        )
        BigDecimal units,

        @Schema(
                description = "Net Asset Value (NAV) per unit used for the trade.",
                example = "51.245600"
        )
        BigDecimal nav,

        @Schema(
                description = "Total trade amount = units × NAV.",
                example = "512.456000"
        )
        BigDecimal amount,

        @Schema(
                description = "Timestamp when the trade was executed (ISO-8601 format).",
                example = "2025-10-28T14:32:55Z"
        )
        String ts
) {}

