package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.service.TradingWindowPolicy;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Component
public class DefaultTradingWindowPolicy implements TradingWindowPolicy {
    private static final LocalTime OPEN = LocalTime.of(9, 0);
    private static final LocalTime CLOSE = LocalTime.of(15, 30);
    @Override
    public boolean isOpen(ZonedDateTime now) {
        var dow = now.getDayOfWeek();
        if (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY) return false;
        var t = now.toLocalTime();
        return !t.isBefore(OPEN) && !t.isAfter(CLOSE);
    }
}