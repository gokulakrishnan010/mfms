package com.acme.mutualfund.config;

import java.time.*;

import org.springframework.stereotype.Component;

@Component
public class TradingClock implements TradingDayProvider {
    public LocalDate today() {
        return LocalDate.now(ZoneId.of("Asia/Kolkata"));
    }
}
