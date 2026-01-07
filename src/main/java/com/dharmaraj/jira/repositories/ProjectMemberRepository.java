package com.dharmaraj.jira.repositories;

import com.dharmaraj.jira.models.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {

    Optional<ProjectMember> findByOrgMember_Id(Long orgMemberId);
}
