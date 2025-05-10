package com.api.quipux_playlist_backend.common.entities;

import com.api.quipux_playlist_backend.common.entities.gnral.Principal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*

 */
@Getter
@Setter
@Entity
@Table(name = "tbl_song")
public class Song extends Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_song", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "artist", length = 50)
    private String artist;

    @Column(name = "album", length = 50)
    private String album;

    @Column(name = "release_year")
    private Integer year;

    @Column(name = "genre", length = 50)
    private String genre;

}
