package com.dharmaraj.jira.services.interfaces;

import com.dharmaraj.jira.models.Member;

public interface MemberService {

    void validateMemberPresenceInOrg(Long memberId, Long orgId);

    Member getMemberById(Long memberId);
}
