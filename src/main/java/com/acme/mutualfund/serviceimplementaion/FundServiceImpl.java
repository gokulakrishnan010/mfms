package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.trading.TradingClock;

import java.math.BigDecimal;
import java.util.*;

import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.entity.Nav;
import com.acme.mutualfund.repository.FundRepository;
import com.acme.mutualfund.repository.NavRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FundServiceImpl {
    private final FundRepository funds;
    private final NavRepository navs;
    private final TradingClock clock;

    @Transactional
    public Fund create(String symbol, String name) {
        if (funds.existsById(symbol)) throw new IllegalArgumentException("FUND_EXISTS");
        return funds.save(Fund.builder().symbol(symbol).name(name).build());
    }

    @Transactional
    public Nav setTodayNav(String symbol, BigDecimal nav) {
        if (nav == null || nav.signum() <= 0) throw new IllegalArgumentException("NAV_MUST_BE_POSITIVE");
        var fund = funds.findById(symbol).orElseThrow(() -> new IllegalArgumentException("FUND_NOT_FOUND"));
        var today = clock.today();
        var existing = navs.findByFundAndDate(fund, today).orElse(null);
        if (existing == null) {
            return navs.save(Nav.builder().fund(fund).date(today).nav(nav).build());
        } else {
            existing.setNav(nav);
            return navs.save(existing);
        }
    }

    public Optional<java.math.BigDecimal> todayNav(String symbol) {
        return funds.findById(symbol)
                .flatMap(f -> navs.findByFundAndDate(f, clock.today()))
                .map(Nav::getNav);
    }

    public List<com.acme.mutualfund.dto.FundDto> listWithTodayNav() {
        var today = clock.today();
        var all = funds.findAll();
        return all.stream().map(f -> {
            var nav = navs.findByFundAndDate(f, today).map(Nav::getNav).orElse(null);
            return new com.acme.mutualfund.dto.FundDto(f.getSymbol(), f.getName(), nav);
        }).toList();
    }
}
