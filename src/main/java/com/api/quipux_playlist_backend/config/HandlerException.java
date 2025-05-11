package com.api.quipux_playlist_backend.config;

import com.api.quipux_playlist_backend.common.exceptions.PlayListException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler({PlayListException.class})
    public ResponseEntity<Object> handlerNotFoundPlayListException(final PlayListException e) {
        log.error("HandlerException.handlerNotFoundException {e}", e);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> handleAccessDeniedException(final AccessDeniedException e) {
        log.error("HandlerException.handleAccessDeniedException {e}", e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Object> handleMethodNotValidException(final MethodArgumentNotValidException e) {
        log.error("HandlerException.handleMethodNotValidException {e}", e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handlerException(final Exception e) {
        log.error("HandlerException.handlerException {e}", e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}