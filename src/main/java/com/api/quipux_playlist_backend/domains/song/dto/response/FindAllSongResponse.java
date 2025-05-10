package com.api.quipux_playlist_backend.domains.song.dto.response;

import com.api.quipux_playlist_backend.domains.song.dto.SongDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FindAllSongResponse {
    private List<SongDTO> listSong;
}
