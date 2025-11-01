package com.acme.mutualfund.trading;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
@Setter
public class TradingClock implements TradingDayProvider {
    private final TradingProps props;


    public LocalDate today() {
        return LocalDate.now(ZoneId.of(props.zone()));
    }

    public ZonedDateTime nowZoned() {
        return ZonedDateTime.now(ZoneId.of(props.zone()));
    }

    public ZoneId zoneId() {
        return ZoneId.of(props.zone());
    }
}
