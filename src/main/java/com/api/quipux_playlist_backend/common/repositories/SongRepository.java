package com.api.quipux_playlist_backend.common.repositories;

import com.api.quipux_playlist_backend.common.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song,Long> {

    List<Song> findByIsActiveTrue();

    Optional<Song> findByIdAndIsActiveTrue(Long id);
}
