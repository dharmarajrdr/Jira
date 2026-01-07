package com.dharmaraj.jira.dtos.project;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberInProjectRequestDto {

    Long projectId;

    Long orgMemberId;

    Long orgMemberIdToAdd;
}
