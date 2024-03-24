package com.example.member.domain.application.outputport;


import com.example.member.domain.model.Member;
import com.example.member.domain.model.vo.IDName;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberOutPutPort {

    Member loadMember(long memberNo);

    Member loadMemberByIdName(IDName idName);

    Member saveMember(Member member);

}
