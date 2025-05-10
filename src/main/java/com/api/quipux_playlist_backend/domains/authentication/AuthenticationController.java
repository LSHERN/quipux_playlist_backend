package com.api.quipux_playlist_backend.domains.authentication;

import com.api.quipux_playlist_backend.domains.authentication.dto.request.LoginRequest;
import com.api.quipux_playlist_backend.domains.authentication.dto.request.RegisterRequest;
import com.api.quipux_playlist_backend.domains.authentication.dto.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(AuthenticationRoute.AUTHENTICATION)
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(AuthenticationRoute.LOGIN)
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody final LoginRequest request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping(AuthenticationRoute.REGISTER)
    public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody final RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }
}