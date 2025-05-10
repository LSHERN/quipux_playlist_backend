package config.services;

import com.api.quipux_playlist_backend.common.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsService implements UserService{

    private final UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        return username -> userRepository.findUserByEmailAndIsActiveTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}