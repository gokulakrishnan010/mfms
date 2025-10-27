package com.acme.mutualfund.portfolio;

import com.acme.mutualfund.config.TradingClock;
import com.acme.mutualfund.fund.*;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PortfolioService {
  private final HoldingRepository holdings;
  private final FundRepository funds;
  private final NavRepository navs;
  private final TradeRepository trades;
  private final TradingClock clock;

  @Transactional
  public Trade buy(String username, String symbol, BigDecimal units){
    var fund = funds.findById(symbol).orElseThrow(() -> new IllegalArgumentException("FUND_NOT_FOUND"));
    var today = clock.today();
    var nav = navs.findByFundAndDateForUpdate(fund, today)
      .orElseThrow(() -> new IllegalArgumentException("NAV_MISSING"));
    if (units == null || units.signum() <= 0) throw new IllegalArgumentException("UNITS_POSITIVE");
    var holding = holdings.findForUpdate(username, fund.getSymbol())
      .orElseGet(() -> Holding.newOf(username, fund));
    holding.addUnits(units);
    holdings.save(holding);
    var amount = nav.getNav().multiply(units);
    var trade = Trade.buy(username, fund, units, nav.getNav(), amount);
    return trades.save(trade);
  }

  @Transactional
  public Trade redeem(String username, String symbol, BigDecimal units){
    var fund = funds.findById(symbol).orElseThrow(() -> new IllegalArgumentException("FUND_NOT_FOUND"));
    var today = clock.today();
    var nav = navs.findByFundAndDateForUpdate(fund, today)
      .orElseThrow(() -> new IllegalArgumentException("NAV_MISSING"));
    if (units == null || units.signum() <= 0) throw new IllegalArgumentException("UNITS_POSITIVE");
    var holding = holdings.findForUpdate(username, fund.getSymbol())
      .orElseThrow(() -> new IllegalArgumentException("NO_HOLDING"));
    if (holding.getUnits().compareTo(units) < 0)
      throw new IllegalArgumentException("REDEEM_UNDERFLOW");
    holding.subtractUnits(units);
    holdings.save(holding);
    var amount = nav.getNav().multiply(units);
    var trade = Trade.redeem(username, fund, units, nav.getNav(), amount);
    return trades.save(trade);
  }
}
