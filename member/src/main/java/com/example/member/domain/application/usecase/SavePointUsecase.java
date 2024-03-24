package com.example.member.domain.application.usecase;

import com.example.member.domain.model.dto.MemberOutPutDTO;
import com.example.member.domain.model.vo.IDName;

public interface SavePointUsecase {
    MemberOutPutDTO savePoint(IDName idName, Long point);
}
