package com.acme.mutualfund.service;

import com.acme.mutualfund.entity.Nav;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface NavService {
    Optional<Nav> getNavFor(String symbol, LocalDate date);
    Nav upsert(String symbol, LocalDate date, BigDecimal nav);
}