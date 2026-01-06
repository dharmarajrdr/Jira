package com.dharmaraj.jira.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
class OrgLevelBaseModel extends BaseModel {

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private OrgMember createdBy;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
