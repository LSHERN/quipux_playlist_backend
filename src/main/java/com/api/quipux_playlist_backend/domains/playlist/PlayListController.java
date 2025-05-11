package com.api.quipux_playlist_backend.domains.playlist;

import com.api.quipux_playlist_backend.domains.playlist.dto.request.CreatedPlayListRequest;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.CreatedPlayListResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.FindDescriptionPlaylistResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.ListPlayListResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(PlayListRoute.PLAY_LIST)
public class PlayListController {

    private final PlayListService playListService;

    @PostMapping(PlayListRoute.CREATE)
    public ResponseEntity<CreatedPlayListResponse> createPlayList(@RequestBody @Valid final CreatedPlayListRequest request){
        CreatedPlayListResponse response = playListService.createPlayList(request);
        return ResponseEntity.created(URI.create(String.format("lists/%d", response.getId()))).body(response);
    }

    @GetMapping
    public ResponseEntity<ListPlayListResponse> findAllPlayList(@RequestParam final int pageNumber, @RequestParam final int pageSize){
        return ResponseEntity.ok(playListService.findAllPlaylist(PageRequest.of(pageNumber,pageSize)));
    }

    @GetMapping(PlayListRoute.LIST_DESCRIPTION)
    public ResponseEntity<FindDescriptionPlaylistResponse> findDescriptionPlaylist(@PathVariable final String listName){
        return ResponseEntity.ok(playListService.findDescriptionPlaylist(listName));
    }

    @DeleteMapping(PlayListRoute.DELETE_LIST)
    public ResponseEntity<Void> deletePlayList(@PathVariable final String listName){
        playListService.deletePlayList(listName);
        return ResponseEntity.noContent().build();
    }


}
