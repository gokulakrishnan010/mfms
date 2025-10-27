package com.acme.mutualfund.auth;

import com.acme.mutualfund.dto.EnrollReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repo;
    private final PasswordEncoder encoder;

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
}
