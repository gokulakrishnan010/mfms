package com.acme.mutualfund.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnrollReq(@NotBlank String username, @Size(min=8) String password) {}

