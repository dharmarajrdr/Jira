package com.dharmaraj.jira.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Org extends BaseModel {

    @Column(nullable = false, unique = true, length = 25)
    private String name;

    @OneToMany(mappedBy = "org")
    private List<Project> projects;
}
