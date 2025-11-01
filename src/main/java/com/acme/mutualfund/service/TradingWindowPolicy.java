package com.acme.mutualfund.service;

import java.time.ZonedDateTime;

public interface TradingWindowPolicy {
    boolean isOpen(ZonedDateTime now);
}
