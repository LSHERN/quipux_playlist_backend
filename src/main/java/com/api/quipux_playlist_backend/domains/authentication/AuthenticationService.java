package com.api.quipux_playlist_backend.domains.authentication;

import com.api.quipux_playlist_backend.domains.authentication.dto.request.LoginRequest;
import com.api.quipux_playlist_backend.domains.authentication.dto.request.RegisterRequest;
import com.api.quipux_playlist_backend.domains.authentication.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse login(LoginRequest request);

    JwtAuthenticationResponse register(RegisterRequest request);
}
