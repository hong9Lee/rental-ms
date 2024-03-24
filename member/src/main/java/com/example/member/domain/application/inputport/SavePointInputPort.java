package com.example.member.domain.application.inputport;

import com.example.member.domain.application.outputport.MemberOutPutPort;
import com.example.member.domain.application.usecase.SavePointUsecase;
import com.example.member.domain.model.Member;
import com.example.member.domain.model.dto.MemberOutPutDTO;
import com.example.member.domain.model.vo.IDName;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class SavePointInputPort implements SavePointUsecase {

    private final MemberOutPutPort memberOutputPort;

    @Override
    public MemberOutPutDTO savePoint(IDName idName, Long point) {
        Member loadMember = memberOutputPort.loadMemberByIdName(idName);
        loadMember.savePoint(point);
        return MemberOutPutDTO.mapToDTO(loadMember);
    }
}
