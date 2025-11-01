package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.dto.FundDto;
import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.entity.Nav;
import com.acme.mutualfund.repository.FundRepository;
import com.acme.mutualfund.repository.NavRepository;
import com.acme.mutualfund.service.FundService;
import com.acme.mutualfund.trading.TradingClock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FundServiceImpl implements FundService {
    private final FundRepository funds;
    private final TradingClock clock;
    private final NavRepository navs;

    @Override
    public Optional<Fund> getBySymbol(String symbol) {
        return funds.findById(symbol);
    }

    @Override
    @Transactional
    public Fund create(String symbol, String name) {
        if (funds.existsById(symbol)) {
            return funds.findById(symbol).get();
        }
        return funds.save(new Fund(symbol, name));
    }

    @Override
    public List<FundDto> fundWithTodayNav() {
        var today = clock.today();
        var all = funds.findAll();
        return all.stream().map(f -> {
            var nav = navs.findByFundAndDate(f, today).map(Nav::getNav).orElse(null);
            return new FundDto(f.getSymbol(), f.getName(), nav);
        }).toList();
    }
}
