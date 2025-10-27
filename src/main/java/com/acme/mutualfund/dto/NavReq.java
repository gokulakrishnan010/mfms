package com.acme.mutualfund.dto;

import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public record NavReq(@DecimalMin(value="0.000001", inclusive=false) BigDecimal nav) {}

