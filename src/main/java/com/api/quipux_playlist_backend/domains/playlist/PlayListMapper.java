package com.api.quipux_playlist_backend.domains.playlist;

import com.api.quipux_playlist_backend.common.entities.PlayList;
import com.api.quipux_playlist_backend.common.entities.Song;
import com.api.quipux_playlist_backend.domains.playlist.dto.SongDTO;
import com.api.quipux_playlist_backend.domains.playlist.dto.request.CreatedPlayListRequest;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.CreatedPlayListResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.FindDescriptionPlaylistResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayListMapper {

    FindDescriptionPlaylistResponse playlistToPlaylistDTO(PlayList playlist);

    CreatedPlayListResponse playlistToCreatePlaylistResponse(PlayList playlist);

    SongDTO songToSongDTO(Song song);

    List<SongDTO> songsToSongDTOs(List<Song> songs);

    PlayList playlistDTOToPlaylist(CreatedPlayListRequest request);
}
