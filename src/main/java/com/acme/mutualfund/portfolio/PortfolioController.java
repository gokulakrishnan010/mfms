package com.acme.mutualfund.portfolio;

import com.acme.mutualfund.dto.*;
import com.acme.mutualfund.fund.*;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
  private final PortfolioService svc;
  private final HoldingRepository holdings;
  private final NavRepository navs;

  @GetMapping
  public PortfolioDto portfolio(Authentication auth){
    var username = auth.getName();
    var today = java.time.LocalDate.now(java.time.ZoneId.of("Asia/Kolkata"));
    var hs = holdings.findByUsername(username);
    var items = new java.util.ArrayList<HoldingDto>();
    java.math.BigDecimal total = java.math.BigDecimal.ZERO;
    for (var h : hs){
      var nav = navs.findByFundAndDate(h.getFund(), today).map(Nav::getNav).orElse(null);
      var value = (nav == null) ? null : nav.multiply(h.getUnits());
      if (value != null) total = total.add(value);
      items.add(new HoldingDto(h.getFund().getSymbol(), h.getUnits(), nav, value));
    }
    return new PortfolioDto(items, total);
  }

  @PostMapping("/buy")
  public TradeDto buy(@Valid @RequestBody TradeReq req, Authentication auth){
    var t = svc.buy(auth.getName(), req.symbol(), req.units());
    return new TradeDto(t.getId(), t.getType().name(), t.getFund().getSymbol(), t.getUnits(), t.getNav(), t.getAmount(), t.getTs().toString());
  }

  @PostMapping("/redeem")
  public TradeDto redeem(@Valid @RequestBody TradeReq req, Authentication auth){
    var t = svc.redeem(auth.getName(), req.symbol(), req.units());
    return new TradeDto(t.getId(), t.getType().name(), t.getFund().getSymbol(), t.getUnits(), t.getNav(), t.getAmount(), t.getTs().toString());
  }
}
