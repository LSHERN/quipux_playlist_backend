package com.api.quipux_playlist_backend.domains.playlist.dto.response;

import com.api.quipux_playlist_backend.common.dto.PaginationDTO;
import com.api.quipux_playlist_backend.common.projections.PlayListProjection;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
public class ListPlayListResponse extends PaginationDTO implements Serializable {

    private List<PlayListProjection> playlists;
}
