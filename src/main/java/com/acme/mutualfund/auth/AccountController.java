package com.acme.mutualfund.auth;

import com.acme.mutualfund.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AccountController {
  private final AccountService accounts;

  @PostMapping("/enroll")
  public ResponseEntity<Void> enroll(@Valid @RequestBody EnrollReq req){
    accounts.enroll(req, false);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/enroll/admin")
  public ResponseEntity<Void> enrollAdmin(@Valid @RequestBody EnrollReq req){
    accounts.enroll(req, true);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/me")
  public PrincipalDto me(Authentication auth){
    var roles = auth.getAuthorities().stream().map(a -> a.getAuthority()).toList();
    return new PrincipalDto(auth.getName(), roles);
  }
}
