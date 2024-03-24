package com.example.member.domain.model.dto;

import com.example.member.domain.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberOutPutDTO {

    private String id;
    private String name;
    private String pwd;
    private String email;
    private long point;

    public static MemberOutPutDTO mapToDTO(Member member) {
        MemberOutPutDTO dto = new MemberOutPutDTO();
        dto.setId(member.getIdName().getId());
        dto.setName(member.getIdName().getName());
        dto.setPwd(member.getPassword().getPastPwd());
        dto.setEmail(member.getEmail().getAddress());
        dto.setPoint(member.getPoint().getPointValue());
        return dto;
    }
}
