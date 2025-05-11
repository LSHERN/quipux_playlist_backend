package com.api.quipux_playlist_backend.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 */
@Getter
@Setter
public class PaginationDTO implements Serializable {

    private int pageSize;
    private int pageNumber;
    private long totalElement;
}
