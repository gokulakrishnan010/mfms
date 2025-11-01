package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.entity.Nav;
import com.acme.mutualfund.repository.FundRepository;
import com.acme.mutualfund.repository.NavRepository;
import com.acme.mutualfund.service.NavService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NavServiceImpl implements NavService {
    private final NavRepository navs;
    private final FundRepository funds;

    @Override
    public Optional<Nav> getNavFor(String symbol, LocalDate date) {
        return funds.findById(symbol).flatMap(f -> navs.findByFundAndDate(f, date));
    }

    @Override
    @Transactional
    public Nav upsert(String symbol, LocalDate date, BigDecimal navValue) {
        Fund fund = funds.findById(symbol).orElseThrow();
        return navs.findByFundAndDate(fund, date)
                .map(n -> { n.setNav(navValue); return navs.save(n); })
                .orElseGet(() -> navs.save(Nav.of(fund, date, navValue)));
    }
}
