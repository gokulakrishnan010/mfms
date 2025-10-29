package com.acme.mutualfund.trading;

import java.time.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TradingClock implements TradingDayProvider {
    private final TradingProps props;
    public LocalDate today() { return LocalDate.now(ZoneId.of(props.zone())); }
}
