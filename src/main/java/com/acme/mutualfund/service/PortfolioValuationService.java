package com.acme.mutualfund.service;

import com.acme.mutualfund.dto.PortfolioDto;

import java.time.LocalDate;
import java.util.List;

public interface PortfolioValuationService {
    PortfolioDto portfolioFor(String username, LocalDate asOf);
    List<PortfolioDto.HoldingView> holdingsFor(String username, LocalDate asOf);
}