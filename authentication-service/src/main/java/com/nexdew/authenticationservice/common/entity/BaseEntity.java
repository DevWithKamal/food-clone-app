package com.nexdew.authenticationservice.common.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private Boolean isDeleted;
}
