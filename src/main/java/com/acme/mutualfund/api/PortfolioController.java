package com.acme.mutualfund.api;

import com.acme.mutualfund.dto.PortfolioDto;
import com.acme.mutualfund.dto.TradeDto;
import com.acme.mutualfund.dto.TradeReq;
import com.acme.mutualfund.facade.PortfolioFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioFacade facade;

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
    public PortfolioDto myPortfolio(Principal principal) {
        return facade.getPortfolio(principal.getName());
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
    public ResponseEntity<TradeDto> buy(Principal p,@Valid @RequestBody TradeReq req) {
        return ResponseEntity.ok(facade.buy(p.getName(), req.symbol(), req.units()));
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
    public ResponseEntity<TradeDto> redeem(Principal p, @Valid @RequestBody TradeReq req) {
        return ResponseEntity.ok(facade.redeem(p.getName(), req.symbol(), req.units()));
    }
}
