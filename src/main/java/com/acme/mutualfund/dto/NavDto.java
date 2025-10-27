package com.acme.mutualfund.dto;

import java.math.BigDecimal;

public record NavDto(String symbol, String date, BigDecimal nav) {}

