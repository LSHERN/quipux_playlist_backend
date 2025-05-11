package com.api.quipux_playlist_backend.domains.playlist;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class PlayListRoute {

    public static final String PLAY_LIST = "lists";
    public static final String LIST_DESCRIPTION = "{listName}";
    public static final String DELETE_LIST = "{listName}";
}
