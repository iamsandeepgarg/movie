package com.booking.movie.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class AuditableEntity extends BaseTimeEntity {

    private String createdBy;
    private String updatedBy;

    @Version
    private Long version;

    private Boolean isActive = true;


}
