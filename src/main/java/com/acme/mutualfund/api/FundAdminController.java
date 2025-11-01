package com.acme.mutualfund.api;

import com.acme.mutualfund.dto.CreateFundReq;
import com.acme.mutualfund.dto.FundDto;
import com.acme.mutualfund.dto.NavDto;
import com.acme.mutualfund.dto.NavReq;
import com.acme.mutualfund.facade.PortfolioFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/funds")
@RequiredArgsConstructor
class FundAdminController {
    private final PortfolioFacade facade;

    @Operation(
            summary = "Create a new fund",
            description = "Admin-only. Creates a mutual fund script with a unique symbol and name."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Fund created",
                    content = @Content(schema = @Schema(implementation = FundDto.class))),
            @ApiResponse(responseCode = "409", description = "Fund already exists"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public void create(@RequestBody CreateFundReq req) {
        facade.createFund(req.symbol(), req.name());
    }


    @Operation(
            summary = "Set today's NAV for a fund",
            description = "Admin-only. Sets or updates the current day's NAV for the specified fund."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "NAV updated",
                    content = @Content(schema = @Schema(implementation = NavDto.class))),
            @ApiResponse(responseCode = "201", description = "NAV created",
                    content = @Content(schema = @Schema(implementation = NavDto.class))),
            @ApiResponse(responseCode = "404", description = "Fund not found"),
            @ApiResponse(responseCode = "422", description = "Invalid NAV value"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PostMapping(value = "/{symbol}/nav", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public void upsert(@PathVariable String symbol, @RequestBody NavReq req) {
        facade.upsertTodayNav(symbol, req.nav());
    }
}

