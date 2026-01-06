package com.dharmaraj.jira.repositories;

import com.dharmaraj.jira.models.OrgMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<OrgMember, Long> {

    boolean existsByIdAndOrg_Id(Long memberId, Long orgId);
}
