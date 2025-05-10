package com.api.quipux_playlist_backend.domains.song;

import com.api.quipux_playlist_backend.common.entities.Song;
import com.api.quipux_playlist_backend.domains.song.dto.SongDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongDTO toDTO(Song song);

    List<SongDTO> toDTOList(List<Song> songs);
}
