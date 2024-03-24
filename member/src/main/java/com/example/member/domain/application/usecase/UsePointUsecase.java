package com.example.member.domain.application.usecase;


import com.example.member.domain.model.dto.MemberOutPutDTO;
import com.example.member.domain.model.vo.IDName;


public interface UsePointUsecase {

    MemberOutPutDTO usePoint(IDName idName, long point) throws Exception;
}
