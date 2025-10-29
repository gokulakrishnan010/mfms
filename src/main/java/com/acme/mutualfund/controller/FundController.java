package com.acme.mutualfund.controller;

import com.acme.mutualfund.dto.*;
import com.acme.mutualfund.serviceimplementaion.FundServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Funds")
@RestController
@RequestMapping("/api/v1/funds")
@RequiredArgsConstructor
@SecurityRequirement(name = "basicAuth")
public class FundController {

    private final FundServiceImpl fundService;

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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<FundDto> create(@Valid @RequestBody CreateFundReq req) {
        var fund = fundService.create(req.symbol(), req.name());
        var dto = new FundDto(fund.getSymbol(), fund.getName(), null);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/{symbol}/nav", consumes = "application/json", produces = "application/json")
    public ResponseEntity<NavDto> setTodayNav(@PathVariable String symbol, @Valid @RequestBody NavReq req) {
        var nav = fundService.setTodayNav(symbol, req.nav());
        var dto = new NavDto(symbol, nav.getDate(), nav.getNav());
        return ResponseEntity.ok(dto);
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
    @GetMapping(produces = "application/json")
    public List<FundDto> list() {
        return fundService.listWithTodayNav();
    }
}
