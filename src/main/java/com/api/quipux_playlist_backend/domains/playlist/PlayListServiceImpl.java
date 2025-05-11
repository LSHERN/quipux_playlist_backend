package com.api.quipux_playlist_backend.domains.playlist;

import com.api.quipux_playlist_backend.common.entities.ListSong;
import com.api.quipux_playlist_backend.common.entities.PlayList;
import com.api.quipux_playlist_backend.common.entities.Song;
import com.api.quipux_playlist_backend.common.entities.gnral.Principal;
import com.api.quipux_playlist_backend.common.exceptions.PlayListException;
import com.api.quipux_playlist_backend.common.projections.PlayListProjection;
import com.api.quipux_playlist_backend.common.repositories.ListSongRepository;
import com.api.quipux_playlist_backend.common.repositories.PlayListRepository;
import com.api.quipux_playlist_backend.common.repositories.SongRepository;
import com.api.quipux_playlist_backend.domains.playlist.dto.SongDTO;
import com.api.quipux_playlist_backend.domains.playlist.dto.request.CreatedPlayListRequest;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.CreatedPlayListResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.FindDescriptionPlaylistResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.ListPlayListResponse;
import com.api.quipux_playlist_backend.domains.playlist.dto.response.PlayListExistResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase encargada de la logica relacionada a las play list.
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class PlayListServiceImpl implements PlayListService{

    private final PlayListRepository playListRepository;
    private final PlayListMapper  playListMapper;
    private final SongRepository songRepository;
    private final ListSongRepository playlistSongRepository;

    /**
     * Metodo encargado de crear play list y agregar canciones
     * @param request
     * @return CreatedPlayListResponse
     */
    @Override
    @Transactional
    public CreatedPlayListResponse createPlayList(CreatedPlayListRequest request) {
        log.info("init method createPlayList");
        //Se valida el nombre y descripción de la lista de reproducción.
        final Boolean nameIsInvalid = request.getName() == null || request.getName().isBlank();
        final Boolean descriptionIsInvalid = request.getDescription() == null || request.getDescription().isBlank();
        if (nameIsInvalid || descriptionIsInvalid) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name or description of play list invalid");
        }
        PlayList playList = playListMapper.playlistDTOToPlaylist(request);
        playListRepository.save(playList);

        final CreatedPlayListResponse response = playListMapper.playlistToCreatePlaylistResponse(playList);

        List<SongDTO> songs = addSongPlaylist(playList, request.getIdSong());
        response.setSongs(songs);
        log.info("finish method createPlayList");
        return response;
    }

    /**
     * Metodo encargado de agregar las canciones a la lista de reproducción
     * @param playList
     * @param idSongs
     * @return List<SongDTO>
     */
    private List<SongDTO> addSongPlaylist(PlayList playList, List<Long> idSongs) {

        log.info("init method addSongPlaylist");
        List<SongDTO> listSongDTO = new ArrayList<>();

        idSongs.forEach(idSong -> {
            Optional<Song> song = songRepository.findByIdAndIsActiveTrue(idSong);
            if (song.isEmpty()) {
                return;
            }
            ListSong listSong = new ListSong();
            listSong.setSong(song.get());
            listSong.setPlayList(playList);
            playlistSongRepository.save(listSong);
            listSongDTO.add(playListMapper.songToSongDTO(song.get()));
        });
        log.info("finish method addSongPlaylist");
        return  listSongDTO;
    }

    /**
     * Metodo encargado de consultar todas las listas de reprodución
     * @param pageable
     * @return
     */
    @Override
    public ListPlayListResponse findAllPlaylist(Pageable pageable) {
        log.info("init method findAllPlaylist");
        final Page<PlayListProjection> page = playListRepository.findByIsActiveTrue(pageable);

        ListPlayListResponse response = ListPlayListResponse
                .builder().playlists(page.getContent())
                .build();
        response.setPageNumber(page.getNumber());
        response.setPageNumber(page.getSize());
        response.setTotalElement(page.getTotalElements());
        log.info("finish method findAllPlaylist");
        return response;
    }

    /**
     * Metodo encargado de buscar la descripcion por nombre de la lista de}
     * reproducción
     * @param nameList
     * @return FindDescriptionPlaylistResponse
     */
    @Override
    @Transactional
    public FindDescriptionPlaylistResponse findDescriptionPlaylist(String nameList) {

        final PlayList playlist = playListRepository.findByNameAndIsActiveTrue(nameList)
                .orElseThrow(PlayListException::new);

        final List<Song> songs = playlist.getListSongs()
                .stream()
                .map(ListSong::getSong)
                .filter(Principal::getIsActive)
                .toList();

        final List<SongDTO> songDTOS = playListMapper.songsToSongDTOs(songs);
        final FindDescriptionPlaylistResponse response = playListMapper.playlistToPlaylistDTO(playlist);
        response.setSongs(songDTOS);
        return response;
    }

    /**
     * Metodo encargado de eliminar una lista de reproducción
     * @param nameList
     */
    @Override
    @Transactional
    public void deletePlayList(String nameList){
        final PlayList playList = playListRepository.findByNameAndIsActiveTrue(nameList).orElseThrow(PlayListException::new);
        playList.setIsActive(Boolean.FALSE);
    }

    /**
     * Metodo encargado de validar si existe la play list consultada por nombre.
     * @param nameList
     * @return
     */
    @Override
    public PlayListExistResponse existsPlaylist(final String nameList) {
        Optional<PlayList> opPlaylist = playListRepository.findByNameAndIsActiveTrue(nameList);
        return new PlayListExistResponse(opPlaylist.isPresent());
    }
}
