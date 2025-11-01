package com.acme.mutualfund.api;

import com.acme.mutualfund.service.AccountService;
import com.acme.mutualfund.dto.EnrollReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@Tag(name = "Auth")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accounts;

    @Operation(
            summary = "Enroll a new USER account",
            description = "Open endpoint. Creates a regular user account."
    )
    @ApiResponse(responseCode = "201", description = "User created")
    @ApiResponse(responseCode = "400", description = "Validation error")
    @ApiResponse(responseCode = "409", description = "Username already exists")
    @PostMapping(value = "/enroll", consumes = "application/json")
    public ResponseEntity<Void> enroll(@Valid @RequestBody EnrollReq req) {
        accounts.enroll(req, false);
        return ResponseEntity
                .created(URI.create("/api/v1/auth/users/" + req.username()))
                .build();
    }

    @Operation(
            summary = "Enroll a new ADMIN account",
            description = "Admin-only. Creates an admin user."
    )
    @ApiResponse(responseCode = "201", description = "Admin created")
    @ApiResponse(responseCode = "400", description = "Validation error")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Username already exists")
    @PostMapping(value = "/enroll/admin", consumes = "application/json")
    public ResponseEntity<Void> enrollAdmin(@Valid @RequestBody EnrollReq req) {
        accounts.enroll(req, true);
        return ResponseEntity
                .created(URI.create("/api/v1/auth/users/" + req.username()))
                .build();
    }
}
