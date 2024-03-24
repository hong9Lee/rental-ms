package com.example.member.domain.application.usecase;

import com.example.member.domain.model.dto.MemberOutPutDTO;

public interface InqueryMemberUsecase {
    MemberOutPutDTO getMember(long memberNo);
}
