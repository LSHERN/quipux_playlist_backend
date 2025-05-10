package com.api.quipux_playlist_backend.domains.authentication;

import com.api.quipux_playlist_backend.common.entities.User;
import com.api.quipux_playlist_backend.common.exceptions.GenericException;
import com.api.quipux_playlist_backend.common.repositories.UserRepository;
import com.api.quipux_playlist_backend.config.JwtProviderToken;
import com.api.quipux_playlist_backend.domains.authentication.dto.request.LoginRequest;
import com.api.quipux_playlist_backend.domains.authentication.dto.request.RegisterRequest;
import com.api.quipux_playlist_backend.domains.authentication.dto.response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProviderToken jwtProviderToken;

    @Override
    public JwtAuthenticationResponse register(final RegisterRequest request) {

        User user = new User();
        user.setEmail(request.getEmail());
        Optional<User> opUser = userRepository.findUserByEmailAndIsActiveTrue(request.getEmail());
        if (opUser.isPresent()) {
            throw new GenericException("ERROR-002");
        }
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        var jwt = jwtProviderToken.createToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse login(final LoginRequest request) {
        User user = userRepository.findUserByEmailAndIsActiveTrue(request.getEmail())
                .orElseThrow(() -> new AccessDeniedException("ERROR-001"));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var jwt = jwtProviderToken.createToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
