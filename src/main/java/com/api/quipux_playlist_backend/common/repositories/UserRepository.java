package com.api.quipux_playlist_backend.common.repositories;

import com.api.quipux_playlist_backend.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailAndIsActiveTrue(String email);
}
