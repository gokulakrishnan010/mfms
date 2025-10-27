package com.acme.mutualfund.dto;

import java.math.BigDecimal;

public record HoldingDto(String symbol, BigDecimal units, BigDecimal todayNav, BigDecimal value) {}
