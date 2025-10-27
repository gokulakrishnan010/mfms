package com.acme.mutualfund.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateFundReq(@NotBlank String symbol, @NotBlank String name) {}
