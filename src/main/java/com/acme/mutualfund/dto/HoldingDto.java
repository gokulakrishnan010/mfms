package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(
        name = "HoldingDto",
        description = "Represents a single fund holding in the user's portfolio, including current NAV and total value."
)
public record HoldingDto(

        @Schema(description = "Symbol of the mutual fund.", example = "ALPHA")
        String symbol,

        @Schema(description = "Number of units currently held.", example = "12.50000000")
        BigDecimal units,

        @Schema(description = "Today's Net Asset Value (NAV) per unit for this fund.",
                example = "50.000000", accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal todayNav,

        @Schema(description = "Total value of this holding = units × today's NAV.",
                example = "625.000000", accessMode = Schema.AccessMode.READ_ONLY)
        BigDecimal valueToday
) {}
