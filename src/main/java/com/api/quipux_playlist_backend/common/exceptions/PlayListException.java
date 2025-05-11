package com.api.quipux_playlist_backend.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
/*
*Clase que determina las excepciones relacionadas a las playlist
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlayListException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PlayListException() {
        super("Playlist Not Found");
    }
}
