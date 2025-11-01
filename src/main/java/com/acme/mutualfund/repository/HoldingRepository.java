package com.acme.mutualfund.repository;

import java.util.*;

import com.acme.mutualfund.entity.Holding;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select h from Holding h where h.username=:username and h.fund.symbol=:symbol")
    Optional<Holding> findByUsernameAndFund(@Param("username") String username, @Param("symbol") String symbol);

    List<Holding> findByUsername(String username);
}
