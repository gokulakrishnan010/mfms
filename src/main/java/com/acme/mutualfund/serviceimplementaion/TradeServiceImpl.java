package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.entity.Trade;
import com.acme.mutualfund.repository.TradeRepository;
import com.acme.mutualfund.service.TradeServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeServiceFacade {
    private final TradeRepository trades;

    @Override
    @Transactional
    public Trade recordBuy(String username, Fund fund, BigDecimal units, BigDecimal nav) {
        var amount = units.multiply(nav);
        var t = Trade.buy(username, fund, units, nav, amount);
        return trades.save(t);
    }

    @Override
    @Transactional
    public Trade recordRedeem(String username, Fund fund, BigDecimal units, BigDecimal nav) {
        var amount = units.multiply(nav);
        var t = Trade.redeem(username, fund, units, nav, amount);
        return trades.save(t);
    }
}
