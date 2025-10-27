package com.acme.mutualfund.config;

import java.time.LocalDate;

public interface TradingDayProvider {
    LocalDate today();
}