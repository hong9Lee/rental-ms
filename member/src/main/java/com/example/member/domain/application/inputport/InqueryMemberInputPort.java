package com.example.member.domain.application.inputport;

import com.example.member.domain.application.outputport.MemberOutPutPort;
import com.example.member.domain.application.usecase.InqueryMemberUsecase;
import com.example.member.domain.model.Member;
import com.example.member.domain.model.dto.MemberOutPutDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class InqueryMemberInputPort implements InqueryMemberUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO getMember(long memberNo) {
        Member loadMember = memberOutPutPort.loadMember(memberNo);
        return MemberOutPutDTO.mapToDTO(loadMember);
    }
}
