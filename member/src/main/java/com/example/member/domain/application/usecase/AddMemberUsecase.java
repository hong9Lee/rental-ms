package com.example.member.domain.application.usecase;

import com.example.member.domain.model.dto.MemberInfoDTO;
import com.example.member.domain.model.dto.MemberOutPutDTO;

public interface AddMemberUsecase {
    MemberOutPutDTO addMember(MemberInfoDTO memberInfoDTO);
}
