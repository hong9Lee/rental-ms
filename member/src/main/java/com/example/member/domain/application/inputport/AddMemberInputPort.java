package com.example.member.domain.application.inputport;

import com.example.member.domain.application.outputport.MemberOutPutPort;
import com.example.member.domain.application.usecase.AddMemberUsecase;
import com.example.member.domain.model.Member;
import com.example.member.domain.model.dto.MemberInfoDTO;
import com.example.member.domain.model.dto.MemberOutPutDTO;
import com.example.member.domain.model.vo.Email;
import com.example.member.domain.model.vo.IDName;
import com.example.member.domain.model.vo.Password;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AddMemberInputPort implements AddMemberUsecase {

    private final MemberOutPutPort memberOutPutPort;
    @Override
    public MemberOutPutDTO addMember(MemberInfoDTO memberInfoDTO) {
        IDName idName = new IDName(memberInfoDTO.getId(), memberInfoDTO.getName());
        Password pwd = new Password(memberInfoDTO.getPwd(), memberInfoDTO.getPwd());
        Email email = new Email(memberInfoDTO.getEmail());
        Member addedMember = Member.registerMember(idName, pwd, email);
        Member savedMember = memberOutPutPort.saveMember(addedMember);
        return MemberOutPutDTO.mapToDTO(savedMember);
    }
}
