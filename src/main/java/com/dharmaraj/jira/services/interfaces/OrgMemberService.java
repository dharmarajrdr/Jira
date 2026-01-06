package com.dharmaraj.jira.services.interfaces;

import com.dharmaraj.jira.models.OrgMember;

public interface OrgMemberService {

    void validateMemberPresenceInOrg(Long memberId, Long orgId);

    OrgMember getMemberById(Long memberId);
}
