package com.acme.mutualfund.portfolio;

import com.acme.mutualfund.config.TradingDayProvider;
import com.acme.mutualfund.dto.*;
import com.acme.mutualfund.fund.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

@Tag(name = "Portfolio")
@RestController
@RequestMapping("/api/v1/portfolio")
@RequiredArgsConstructor
@SecurityRequirement(name = "basicAuth")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class PortfolioController {

    private final PortfolioService portfolioService;
    private final HoldingRepository holdings;
    private final NavRepository navs;
    private final TradingDayProvider tradingDay; // inject instead of hardcoding timezone

    @Operation(
            summary = "Get current user's portfolio (valued at today's NAV)",
            description = "Returns all holdings and total value computed using today's NAV. If a holding has no NAV for today, its value is omitted from the total."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = PortfolioDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @GetMapping(produces = "application/json")
    public PortfolioDto portfolio(Authentication auth) {
        final String username = auth.getName();
        final LocalDate today = tradingDay.today(); // single source of truth

        var hs = holdings.findByUsername(username); // Expect this to JOIN fetch fund if needed
        if (hs.isEmpty()) {
            return new PortfolioDto(List.of(), BigDecimal.ZERO.setScale(6, RoundingMode.HALF_UP));
        }

        // Batch load today's NAVs to avoid N+1:
        var fundSymbols = hs.stream().map(h -> h.getFund().getSymbol()).distinct().toList();
        var navList = navs.findAllBySymbolInAndDate(fundSymbols, today); // write a repo method
        Map<String, BigDecimal> navBySymbol = new HashMap<>(navList.size());
        navList.forEach(n -> navBySymbol.put(n.getFund().getSymbol(), n.getNav()));

        var items = new ArrayList<HoldingDto>(hs.size());
        BigDecimal total = BigDecimal.ZERO;

        for (var h : hs) {
            var symbol = h.getFund().getSymbol();
            var nav = navBySymbol.get(symbol); // may be null if admin didn’t set today’s NAV
            BigDecimal valueToday = null;
            if (nav != null) {
                valueToday = nav.multiply(h.getUnits()).setScale(6, RoundingMode.HALF_UP);
                total = total.add(valueToday);
            }
            items.add(new HoldingDto(symbol,
                    h.getUnits().setScale(8, RoundingMode.HALF_UP),
                    nav == null ? null : nav.setScale(6, RoundingMode.HALF_UP),
                    valueToday));
        }

        return new PortfolioDto(items, total.setScale(6, RoundingMode.HALF_UP));
    }

    @Operation(
            summary = "Buy units at today's NAV",
            description = "Creates a BUY trade. Requires today's NAV to be present for the fund."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = TradeDto.class))),
            @ApiResponse(responseCode = "422", description = "Business rule violation (e.g., NAV missing, invalid units)"),
            @ApiResponse(responseCode = "409", description = "Conflict (optimistic lock)"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PostMapping(value = "/buy", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TradeDto> buy(@Valid @RequestBody TradeReq req, Authentication auth) {
        var trade = portfolioService.buy(auth.getName(), req.symbol(), req.units());
        var dto = new TradeDto(
                trade.getId(),
                trade.getType(),
                trade.getFund().getSymbol(),
                trade.getUnits().setScale(8, RoundingMode.HALF_UP),
                trade.getNav().setScale(6, RoundingMode.HALF_UP),
                trade.getAmount().setScale(6, RoundingMode.HALF_UP),
                trade.getTs()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Operation(
            summary = "Redeem units at today's NAV",
            description = "Creates a REDEEM trade. Fails if attempting to redeem more units than held."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = TradeDto.class))),
            @ApiResponse(responseCode = "422", description = "Business rule violation (e.g., redeem underflow, NAV missing)"),
            @ApiResponse(responseCode = "409", description = "Conflict (optimistic lock)"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PostMapping(value = "/redeem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TradeDto> redeem(@Valid @RequestBody TradeReq req, Authentication auth) {
        var trade = portfolioService.redeem(auth.getName(), req.symbol(), req.units());
        var dto = new TradeDto(
                trade.getId(),
                trade.getType(),
                trade.getFund().getSymbol(),
                trade.getUnits().setScale(8, RoundingMode.HALF_UP),
                trade.getNav().setScale(6, RoundingMode.HALF_UP),
                trade.getAmount().setScale(6, RoundingMode.HALF_UP),
                trade.getTs()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
