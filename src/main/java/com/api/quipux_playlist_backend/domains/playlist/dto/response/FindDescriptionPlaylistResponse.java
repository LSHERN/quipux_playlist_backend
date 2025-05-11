package com.api.quipux_playlist_backend.domains.playlist.dto.response;

import com.api.quipux_playlist_backend.domains.playlist.dto.SongDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class FindDescriptionPlaylistResponse {

    private String name;
    private String description;
    private List<SongDTO> songs;
}
