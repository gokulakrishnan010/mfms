package com.acme.mutualfund.fund;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;

public interface NavRepository extends JpaRepository<Nav, Long> {
    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select n from Nav n where n.fund = :fund and n.date = :date")
    Optional<Nav> findByFundAndDateForUpdate(@Param("fund") Fund fund, @Param("date") LocalDate date);

    Optional<Nav> findByFundAndDate(Fund fund, LocalDate date);

    @Query("select n from Nav n where n.fund.symbol in :symbols and n.date = :date")
    List<Nav> findAllBySymbolInAndDate(Collection<String> symbols, LocalDate date);
}
