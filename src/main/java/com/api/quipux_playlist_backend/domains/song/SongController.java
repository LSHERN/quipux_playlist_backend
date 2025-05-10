package com.api.quipux_playlist_backend.domains.song;

import com.api.quipux_playlist_backend.domains.song.dto.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(SongRoute.SONGS)
public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDTO>> findAllSong(){
        return ResponseEntity.ok(songService.findAllActiveSongs());
    }
}
