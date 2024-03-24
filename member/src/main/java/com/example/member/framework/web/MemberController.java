package com.example.member.framework.web;

import com.example.member.domain.application.usecase.AddMemberUsecase;
import com.example.member.domain.application.usecase.InqueryMemberUsecase;
import com.example.member.domain.model.dto.MemberInfoDTO;
import com.example.member.domain.model.dto.MemberOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final AddMemberUsecase addMemberUsecase;
    private final InqueryMemberUsecase inqueryMemberUsecase;

    @PostMapping("/member")
    public ResponseEntity<MemberOutPutDTO> addMember(@RequestBody MemberInfoDTO memberInfoDTO) {
        MemberOutPutDTO dto = addMemberUsecase.addMember(memberInfoDTO);
        return new ResponseEntity<>(dto, CREATED);
    }

    @GetMapping("/member/{no}")
    public ResponseEntity<MemberOutPutDTO> getMember(@PathVariable("no") long no) {
        MemberOutPutDTO member = inqueryMemberUsecase.getMember(no);
        return member != null
                ? new ResponseEntity<>(member, OK)
                : new ResponseEntity<>(NOT_FOUND);
    }

}
