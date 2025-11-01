package com.acme.mutualfund.service;

import com.acme.mutualfund.dto.FundDto;
import com.acme.mutualfund.entity.Fund;

import java.util.List;
import java.util.Optional;

public interface FundService {
    Optional<Fund> getBySymbol(String symbol);
    Fund create(String symbol, String name);
    List<FundDto> fundWithTodayNav();
}
