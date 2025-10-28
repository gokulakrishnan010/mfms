package com.acme.mutualfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(name = "NavReq", description = "Request payload to set or update today's NAV for a fund.")
public record NavReq(

        @NotNull
        @DecimalMin(value = "0.0001", inclusive = false)
        @Schema(
                description = "Today's Net Asset Value (NAV) per unit. Must be greater than 0.0001.",
                example = "51.245600"
        )
        BigDecimal nav
) {}
