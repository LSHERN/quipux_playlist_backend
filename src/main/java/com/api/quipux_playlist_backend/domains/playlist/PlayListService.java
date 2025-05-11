package com.api.quipux_playlist_backend.domains.playlist;

import com.api.quipux_playlist_backend.domains.playlist.dto.request.CreatedPlayListRequest;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.CreatedPlayListResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.FindDescriptionPlaylistResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.ListPlayListResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.PlayListExistResponse;
import org.springframework.data.domain.Pageable;

public interface PlayListService {

    CreatedPlayListResponse createPlayList(CreatedPlayListRequest request);
    ListPlayListResponse findAllPlaylist(Pageable pageable);
    FindDescriptionPlaylistResponse findDescriptionPlaylist(String nameList);
    void deletePlayList(String nameList);
    PlayListExistResponse existsPlaylist(final String nameList);
}
