package com.api.quipux_playlist_backend.common.repositories;

import com.api.quipux_playlist_backend.common.entities.PlayList;
import com.api.quipux_playlist_backend.common.projections.PlayListProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayListRepository extends JpaRepository<PlayList,Long> {


    Optional<PlayList> findByNameAndIsActiveTrue(String name);

    Page<PlayListProjection> findByIsActiveTrue(Pageable pageable);
}
