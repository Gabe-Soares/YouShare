package com.youshare.authapi.domain.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthDTO(@NotBlank String username, @NotBlank String password) {
}
