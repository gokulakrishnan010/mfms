package com.acme.mutualfund.service;

import com.acme.mutualfund.dto.EnrollReq;

public interface AccountService {
    void enroll(EnrollReq req, boolean admin);
    void disable(String username);
}
