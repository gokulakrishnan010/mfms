package com.acme.mutualfund.dto;

import com.acme.mutualfund.entity.Trade;
import com.acme.mutualfund.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.Instant;

@Schema(name = "TradeDto", description = "Represents a trade transaction (buy or redeem) performed by a user.")
public record TradeDto(
        @Schema(description = "Unique identifier of the trade transaction.", example = "1001",
                accessMode = Schema.AccessMode.READ_ONLY)
        Long id,

        @Schema(description = "Type of trade operation — BUY or REDEEM.", example = "BUY")
        TransactionType type,   // enum below

        @Schema(description = "Symbol of the mutual fund involved in the trade.", example = "ALPHA")
        String symbol,

        @Schema(description = "Number of units bought or redeemed.", example = "10.00000000")
        BigDecimal units,

        @Schema(description = "Net Asset Value (NAV) per unit used for the trade.", example = "51.245600",
                accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal nav,

        @Schema(description = "Total trade amount = units × NAV.", example = "512.456000",
                accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal amount,

        @Schema(description = "Timestamp when the trade was executed.", example = "2025-10-28T14:32:55Z",
                format = "date-time", accessMode = Schema.AccessMode.READ_ONLY)
        Instant ts
) {
    public static TradeDto from(Trade t) {
        var symbol = t.getFund() != null ? t.getFund().getSymbol() : null;
        return new TradeDto(
                t.getId(), t.getType(), symbol, t.getUnits(),
                 t.getNav(), t.getAmount(), t.getTs()
        );
    }
}
