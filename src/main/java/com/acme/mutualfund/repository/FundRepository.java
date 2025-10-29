package com.acme.mutualfund.repository;

import com.acme.mutualfund.entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, String> {
}
