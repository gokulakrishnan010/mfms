package com.acme.mutualfund.repository;

import java.util.Optional;

import com.acme.mutualfund.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<UserAccount, String> {
    Optional<UserAccount> findByUsername(String username);

    boolean existsByUsername(String username);
}
