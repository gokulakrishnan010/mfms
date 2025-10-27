package com.acme.mutualfund.portfolio;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("select h from Holding h where h.username=:username and h.fund.symbol=:symbol")
  Optional<Holding> findForUpdate(@Param("username") String username, @Param("symbol") String symbol);
  java.util.List<Holding> findByUsername(String username);
}
