package com.dharmaraj.jira.services.implementations;

import com.dharmaraj.jira.custom_exceptions.MemberNotFoundException;
import com.dharmaraj.jira.custom_exceptions.PermissionDeniedException;
import com.dharmaraj.jira.models.OrgMember;
import com.dharmaraj.jira.repositories.MemberRepository;
import com.dharmaraj.jira.services.interfaces.OrgMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrgMemberServiceImpl implements OrgMemberService {

    private final MemberRepository memberRepository;

    @Override
    public void validateMemberPresenceInOrg(Long memberId, Long orgId) {

        if (!memberRepository.existsByIdAndOrg_Id(memberId, orgId)) {
            throw new PermissionDeniedException("You are not part of this org.");
        }
    }

    @Override
    public OrgMember getMemberById(Long memberId) {

        return memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
    }
}
