package com.acme.mutualfund.service;

import com.acme.mutualfund.entity.Holding;

import java.math.BigDecimal;

public interface HoldingService {
    Holding getOrCreate(String username, String symbol);
    void addUnits(Holding holding, BigDecimal units);
    void subtractUnits(Holding holding, BigDecimal units);
}