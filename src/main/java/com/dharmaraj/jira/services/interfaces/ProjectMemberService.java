package com.dharmaraj.jira.services.interfaces;

import com.dharmaraj.jira.models.ProjectMember;

public interface ProjectMemberService {

    ProjectMember getProjectMemberByOrgMemberId(Long id);
}
