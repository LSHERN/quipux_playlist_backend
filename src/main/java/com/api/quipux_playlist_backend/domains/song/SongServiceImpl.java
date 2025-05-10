package com.api.quipux_playlist_backend.domains.song;

import com.api.quipux_playlist_backend.common.entities.Song;
import com.api.quipux_playlist_backend.common.repositories.SongRepository;
import com.api.quipux_playlist_backend.domains.song.dto.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public List<SongDTO> findAllActiveSongs() {
        List<Song> songs = songRepository.findByIsActiveTrue();
        return songMapper.toDTOList(songs);
    }
}
