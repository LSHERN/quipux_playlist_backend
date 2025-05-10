package com.api.quipux_playlist_backend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class JwtAuthToken extends UsernamePasswordAuthenticationToken {

    private final String token;

    public JwtAuthToken(final String token) {
        super(null, null);
        this.token = token;
        setAuthenticated(false);
    }
}