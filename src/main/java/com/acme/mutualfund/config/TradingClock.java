package com.acme.mutualfund.config;

import java.time.*;

import org.springframework.stereotype.Component;

@Component
public class TradingClock {
    public LocalDate today() {
        return LocalDate.now(ZoneId.of("Asia/Kolkata"));
    }
}
