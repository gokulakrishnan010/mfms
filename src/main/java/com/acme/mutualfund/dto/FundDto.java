package com.acme.mutualfund.dto;

import java.math.BigDecimal;

public record FundDto(String symbol, String name, BigDecimal todayNav) {
}

