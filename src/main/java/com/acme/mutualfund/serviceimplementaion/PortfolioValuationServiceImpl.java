package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.dto.PortfolioDto;
import com.acme.mutualfund.entity.Nav;
import com.acme.mutualfund.repository.HoldingRepository;
import com.acme.mutualfund.repository.NavRepository;
import com.acme.mutualfund.service.PortfolioValuationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioValuationServiceImpl implements PortfolioValuationService {
    private final HoldingRepository holdings;
    private final NavRepository navs;

    @Override
    public PortfolioDto portfolioFor(String username, LocalDate asOf) {
        var holdingViews = holdings.findByUsername(username).stream().map(h -> {
            var nav = navs.findByFundAndDate(h.getFund(), asOf).map(Nav::getNav).orElse(BigDecimal.ZERO);
            var value = h.getUnits().multiply(nav);
            return new PortfolioDto.HoldingView(h.getFund().getSymbol(), h.getUnits(), nav, value);
        }).toList();

        var total = holdingViews.stream()
                .map(PortfolioDto.HoldingView::value)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new PortfolioDto(holdingViews, total, asOf);
    }

    @Override
    public List<PortfolioDto.HoldingView> holdingsFor(String username, LocalDate asOf) {
        return portfolioFor(username, asOf).holdings();
    }
}
