package com.acme.mutualfund.fund;

import com.acme.mutualfund.dto.*;
import jakarta.validation.Valid;

import java.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/funds")
@RequiredArgsConstructor
public class FundController {
    private final FundService svc;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<FundDto> create(@Valid @RequestBody CreateFundReq req) {
        var f = svc.create(req);
        var todayNav = svc.todayNav(f.getSymbol()).orElse(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FundDto(f.getSymbol(), f.getName(), todayNav));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{symbol}/nav")
    public ResponseEntity<NavDto> setTodayNav(@PathVariable String symbol, @Valid @RequestBody NavReq req) {
        var n = svc.setTodayNav(symbol, req.nav());
        return ResponseEntity.ok(new NavDto(symbol, n.getDate().toString(), n.getNav()));
    }

    @GetMapping
    public List<FundDto> list() {
        return svc.listWithTodayNav();
    }
}
