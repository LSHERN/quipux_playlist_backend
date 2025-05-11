package com.api.quipux_playlist_backend.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GenericException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public GenericException(final String message) {
        super(message);
    }
}
