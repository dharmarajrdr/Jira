package com.dharmaraj.jira.repositories;

import com.dharmaraj.jira.models.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<Org, Long> {
}
