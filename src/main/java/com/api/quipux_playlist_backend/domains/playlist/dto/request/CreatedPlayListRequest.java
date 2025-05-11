package com.api.quipux_playlist_backend.domains.playlist.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatedPlayListRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private List<Long> idSong;

}
