package com.acme.mutualfund.api;

import com.acme.mutualfund.repository.AccountRepository;
import com.acme.mutualfund.service.AccountService;
import com.acme.mutualfund.dto.PrincipalDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Admin")
@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "basicAuth")
@RequiredArgsConstructor
class AdminController {

    private final AccountService accounts;
    private final AccountRepository repo;

    @Operation(
            summary = "List users",
            description = "Admin-only. Returns usernames with their roles."
    )
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = PrincipalDto.class)))
    @GetMapping("/users")
    ResponseEntity<List<PrincipalDto>> listUsers() {
        var users = repo.findAll().stream()
                .map(u -> new PrincipalDto(
                        u.getUsername(),
                        List.of("ROLE_" + u.getRole().name())
                ))
                .toList();
        return ResponseEntity.ok(users);
    }

    @Operation(
            summary = "Disable a user",
            description = "Admin-only. Soft-disables the user (enabled=false). Transaction history is retained."
    )
    @ApiResponse(responseCode = "204", description = "User disabled")
    @ApiResponse(responseCode = "404", description = "User not found")
    @DeleteMapping("/users/{username}")
    ResponseEntity<Void> disable(@PathVariable String username) {
        accounts.disable(username);
        return ResponseEntity.noContent().build();
    }
}
