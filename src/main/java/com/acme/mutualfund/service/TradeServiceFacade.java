package com.acme.mutualfund.service;

import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.entity.Trade;

import java.math.BigDecimal;

public interface TradeServiceFacade {
    Trade recordBuy(String username, Fund fund, BigDecimal units, BigDecimal nav);
    Trade recordRedeem(String username, Fund fund, BigDecimal units, BigDecimal nav);
}
