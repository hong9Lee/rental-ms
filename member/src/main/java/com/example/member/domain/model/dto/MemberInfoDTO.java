package com.example.member.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberInfoDTO {
    private String id;
    private String name;
    private String pwd;
    private String email;
}
