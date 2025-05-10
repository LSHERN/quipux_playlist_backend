package com.api.quipux_playlist_backend.domains.authentication.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class JwtAuthenticationResponse {

    private String token;
}

