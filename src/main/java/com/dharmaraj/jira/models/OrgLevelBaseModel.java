package com.dharmaraj.jira.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
class OrgLevelBaseModel extends BaseModel {

    @ManyToOne
    @JoinColumn(nullable = false, updatable = false)
    private OrgMember createdBy;
}
