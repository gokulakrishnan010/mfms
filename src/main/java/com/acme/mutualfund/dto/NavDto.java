package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(name = "NavDto", description = "Represents the Net Asset Value (NAV) of a mutual fund for a specific date.")
public record NavDto(

        @Schema(description = "Unique symbol of the mutual fund.", example = "ALPHA")
        String symbol,

        @Schema(description = "Date for which the NAV is applicable.", example = "2025-10-28", format = "date")
        LocalDate date,

        @Schema(description = "Net Asset Value (NAV) per unit for the given date.", example = "51.245600")
        BigDecimal nav
) {}
