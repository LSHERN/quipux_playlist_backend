package com.api.quipux_playlist_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class QuipuxPlaylistBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuipuxPlaylistBackendApplication.class, args);
    }

}
