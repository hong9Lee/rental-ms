package com.example.member.framework.jpaadapter;


import com.example.member.domain.model.Member;
import com.example.member.domain.model.vo.IDName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByIdName(IDName idName);

}
