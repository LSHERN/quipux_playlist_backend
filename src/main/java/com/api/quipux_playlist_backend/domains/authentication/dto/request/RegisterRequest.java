package com.api.quipux_playlist_backend.domains.authentication.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}