package com.acme.mutualfund;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = com.acme.mutualfund.MfmsApplication.class)
@ActiveProfiles("test")
class MfmsApplicationTests {
    @Test
    void contextLoads() {
        // smoke test
    }
}