package com.acme.mutualfund.dto;

import java.math.BigDecimal;

public record PortfolioDto(java.util.List<HoldingDto> holdings, BigDecimal totalValue) {}

