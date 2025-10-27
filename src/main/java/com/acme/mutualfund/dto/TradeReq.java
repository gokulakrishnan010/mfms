package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(
        name = "TradeReq",
        description = "Request payload to initiate a trade operation (buy or redeem) for a mutual fund."
)
public record TradeReq(

        @NotBlank
        @Schema(
                description = "Symbol of the mutual fund to trade.",
                example = "ALPHA"
        )
        String symbol,

        @NotNull
        @DecimalMin(value = "0.0000001", inclusive = false)
        @Schema(
                description = "Number of fund units to buy or redeem. Must be greater than 0.",
                example = "10.00000000"
        )
        BigDecimal units
) {}