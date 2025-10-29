package com.acme.mutualfund.trading;

import java.time.LocalDate;

public interface TradingDayProvider {
    LocalDate today();
}