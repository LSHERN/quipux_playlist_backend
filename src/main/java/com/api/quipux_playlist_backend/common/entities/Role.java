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
*
 */
@Getter
@Setter
@Entity
@Table(name = "tbl_role")
public class Role extends Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;
}
