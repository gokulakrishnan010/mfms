package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.errors.BusinessRuleException;
import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.entity.Holding;
import com.acme.mutualfund.repository.FundRepository;
import com.acme.mutualfund.repository.HoldingRepository;
import com.acme.mutualfund.service.HoldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class HoldingServiceImpl implements HoldingService {
    private final HoldingRepository holdings;
    private final FundRepository funds;

    @Override
    @Transactional
    public Holding getOrCreate(String username, String symbol) {
        Fund fund = funds.findById(symbol).orElseThrow();
        return holdings.findByUsernameAndFund(username, fund.getSymbol())
                .orElseGet(() -> holdings.save(Holding.newOf(username, fund)));
    }

    @Override
    @Transactional
    public void addUnits(Holding holding, BigDecimal units) {
        holding.addUnits(units);
        try {
            holdings.saveAndFlush(holding);
        } catch (OptimisticLockingFailureException ex) {
            throw new BusinessRuleException("CONFLICT_RETRY");
        }
    }

    @Override
    @Transactional
    public void subtractUnits(Holding holding, BigDecimal units) {
        if (holding.getUnits().compareTo(units) < 0) {
            throw new BusinessRuleException("INSUFFICIENT_UNITS");
        }
        holding.subtractUnits(units);
        try {
            holdings.saveAndFlush(holding);
        } catch (OptimisticLockingFailureException ex) {
            throw new BusinessRuleException("CONFLICT_RETRY");
        }
    }
}
