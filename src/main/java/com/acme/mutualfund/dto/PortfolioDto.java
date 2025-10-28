package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;

@Schema(
        name = "PortfolioDto",
        description = "Represents the current user's mutual fund portfolio, including all holdings and the total value based on today's NAV."
)
public record PortfolioDto(

        @ArraySchema(
                schema = @Schema(implementation = HoldingDto.class),
                arraySchema = @Schema(
                        description = "List of holdings in the user's portfolio, each including symbol, units, NAV, and value."
                )
        )
        List<HoldingDto> holdings,

        @Schema(
                description = "Total current value of all holdings based on today's NAV.",
                example = "625.000000"
        )
        BigDecimal totalValueToday
) {}
