package com.acme.mutualfund.dto;

import java.math.BigDecimal;

public record TradeDto(Long id, String type, String symbol, BigDecimal units, BigDecimal nav, BigDecimal amount,
                       String ts) {
}

