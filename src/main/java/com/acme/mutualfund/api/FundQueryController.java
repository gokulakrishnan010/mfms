package com.acme.mutualfund.api;

import com.acme.mutualfund.dto.FundDto;
import com.acme.mutualfund.entity.Fund;
import com.acme.mutualfund.entity.Nav;
import com.acme.mutualfund.repository.FundRepository;
import com.acme.mutualfund.service.FundService;
import com.acme.mutualfund.service.NavService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/funds")
@RequiredArgsConstructor
public class FundQueryController {

    private final FundRepository funds;
    private final NavService navs;
    private final FundService fundservice;

    @Operation(
            summary = "List all funds available",
            description = "Accessible to all authenticated users."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = Fund.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(produces = "application/json")
    public List<Fund> allFund() {
        return funds.findAll();
    }

    @GetMapping(path = "/{symbol}",produces = "application/json")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Fund> get(@PathVariable String symbol) {
        return funds.findById(symbol)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/{symbol}/nav",produces = "application/json")
    public ResponseEntity<Nav> nav(@PathVariable String symbol,
                                   @RequestParam(required = false) LocalDate date) {
        var when = (date == null) ? LocalDate.now() : date;
        return navs.getNavFor(symbol, when)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "List all funds with today's NAV (if available)",
            description = "Accessible to all authenticated users."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = FundDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(path="/today",produces = "application/json")
    public List<FundDto> fundWithTodayNav() {
        return fundservice.fundWithTodayNav();
    }
}
