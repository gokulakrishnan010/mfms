package com.acme.mutualfund.serviceimplementaion;

import com.acme.mutualfund.dto.EnrollReq;
import com.acme.mutualfund.entity.UserAccount;
import com.acme.mutualfund.enums.Role;
import com.acme.mutualfund.repository.AccountRepository;
import com.acme.mutualfund.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public void enroll(EnrollReq req, boolean admin) {
        if (repo.existsByUsername(req.username())) {
            throw new IllegalArgumentException("USERNAME_TAKEN");
        }
        var role = admin ? Role.ADMIN : Role.USER;
        var acc = UserAccount.builder()
                .username(req.username())
                .passwordHash(encoder.encode(req.password()))
                .role(role)
                .enabled(true)
                .build();
        repo.save(acc);
    }

    @Override
    @Transactional
    public void disable(String username) {
        var acc = repo.findById(username).orElseThrow();
        acc.setEnabled(false);
        repo.save(acc);
    }
}
