package com.api.quipux_playlist_backend.domains.playlist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SongDTO {

    private Long id;
    private String title;
    private String artist;
    private String album;
    private Integer year;
    private String genre;
}