package com.acme.mutualfund.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record TradeReq(@NotBlank String symbol, @DecimalMin(value = "0.000001", inclusive = false) BigDecimal units) {
}

