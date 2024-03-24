package com.example.member.domain.application.inputport;

import com.example.member.domain.application.outputport.MemberOutPutPort;
import com.example.member.domain.application.usecase.UsePointUsecase;
import com.example.member.domain.model.Member;
import com.example.member.domain.model.dto.MemberOutPutDTO;
import com.example.member.domain.model.vo.IDName;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class UsePointInputPort implements UsePointUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO usePoint(IDName idName, long point) throws Exception {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.usePoint(point);
        return MemberOutPutDTO.mapToDTO(loadMember);
    }
}
