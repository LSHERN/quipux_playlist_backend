package com.api.quipux_playlist_backend.domains.song;

import com.api.quipux_playlist_backend.domains.song.dto.SongDTO;

import java.util.List;

public interface SongService {

    List<SongDTO> findAllActiveSongs();
}
