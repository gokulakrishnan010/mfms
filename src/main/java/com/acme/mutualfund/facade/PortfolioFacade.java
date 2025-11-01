package com.acme.mutualfund.facade;

import java.math.BigDecimal;
import java.util.List;

import com.acme.mutualfund.dto.PortfolioDto;
import com.acme.mutualfund.dto.TradeDto;

public interface PortfolioFacade {
    // trading
    TradeDto buy(String username, String symbol, BigDecimal units);
    TradeDto redeem(String username, String symbol, BigDecimal units);

    // fund + nav admin ops
    void createFund(String symbol, String name);
    void upsertTodayNav(String symbol, BigDecimal nav);

    // queries
    PortfolioDto getPortfolio(String username);
    List<PortfolioDto.HoldingView> getHoldings(String username);
}