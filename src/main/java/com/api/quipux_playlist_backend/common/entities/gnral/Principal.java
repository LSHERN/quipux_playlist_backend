package com.api.quipux_playlist_backend.common.entities.gnral;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Entity encargada de información de auditoria.
 */
@Getter
@Setter
@MappedSuperclass
public class Principal {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", insertable = false)
    private Date createdDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @PrePersist
    @PreUpdate
    public void setDefaultIsActiveValue() {
        if (isActive == null)
            isActive = Boolean.TRUE;
    }
}
