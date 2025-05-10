package com.api.quipux_playlist_backend.domains.authentication;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthenticationRoute {

    public static final String AUTHENTICATION = "authentication";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
}
