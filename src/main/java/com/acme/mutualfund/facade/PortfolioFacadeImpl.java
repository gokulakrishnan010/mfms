package com.acme.mutualfund.facade;

import com.acme.mutualfund.entity.Nav;
import com.acme.mutualfund.errors.NotFoundException;
import com.acme.mutualfund.errors.TradingClosedException;
import com.acme.mutualfund.dto.PortfolioDto;
import com.acme.mutualfund.dto.TradeDto;
import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.service.*;
import com.acme.mutualfund.trading.TradingClock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PortfolioFacadeImpl implements PortfolioFacade {

    private final FundService fundService;
    private final NavService navService;
    private final HoldingService holdingService;
    private final TradeServiceFacade tradeService;
    private final PortfolioValuationService valuationService;
    private final TradingClock clock; // encapsulates zone + “today()”
    private final TradingWindowPolicy tradingWindowPolicy; // strategy/policy

    @Override
    @Transactional
    public TradeDto buy(String username, String symbol, BigDecimal units) {
        ensureTradingOpenOrThrow();

        Fund fund = getFund(symbol);

        var nav = getNav(fund);

        var holding = holdingService.getOrCreate(username, fund.getSymbol());
        holdingService.addUnits(holding, units);

        var trade = tradeService.recordBuy(username, fund, units, nav.getNav());
        return TradeDto.from(trade);
    }

    @Override
    @Transactional
    public TradeDto redeem(String username, String symbol, BigDecimal units) {
        ensureTradingOpenOrThrow();

        Fund fund = getFund(symbol);

       var nav = getNav(fund);

        var holding = holdingService.getOrCreate(username, fund.getSymbol());
        holdingService.subtractUnits(holding, units);

        var trade = tradeService.recordRedeem(username, fund, units, nav.getNav());
        return TradeDto.from(trade);
    }

    @Override
    @Transactional
    public void createFund(String symbol, String name) {
        fundService.create(symbol, name);
    }

    @Override
    @Transactional
    public void upsertTodayNav(String symbol, BigDecimal nav) {
        var fund = fundService.getBySymbol(symbol)
                .orElseThrow(() -> new NotFoundException("FUND_NOT_FOUND"));
        navService.upsert(fund.getSymbol(), clock.today(), nav);
    }

    @Override
    @Transactional(readOnly = true)
    public PortfolioDto getPortfolio(String username) {
        return valuationService.portfolioFor(username, clock.today());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PortfolioDto.HoldingView> getHoldings(String username) {
        return valuationService.holdingsFor(username, clock.today());
    }

    private void ensureTradingOpenOrThrow() {
        if (!tradingWindowPolicy.isOpen(clock.nowZoned())) {
            throw new TradingClosedException("TRADING_CLOSED");
        }
    }

    public Nav getNav(Fund fund){
        LocalDate today = clock.today();
        return navService.getNavFor(fund.getSymbol(), today)
                .orElseThrow(() -> new NotFoundException("NAV_NOT_FOUND"));
    }
    public Fund getFund(String symbol){
        return fundService.getBySymbol(symbol)
                .orElseThrow(() -> new NotFoundException("FUND_NOT_FOUND"));
    }
}
