package com.acme.mutualfund.repository;

import com.acme.mutualfund.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
