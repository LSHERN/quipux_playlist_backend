package com.api.quipux_playlist_backend.common.repositories;

import com.api.quipux_playlist_backend.common.entities.ListSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListSongRepository extends JpaRepository<ListSong,Long> {
}
