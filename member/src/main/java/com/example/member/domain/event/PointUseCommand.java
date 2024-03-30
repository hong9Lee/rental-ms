package com.example.member.domain.event;

import com.example.member.domain.model.vo.IDName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PointUseCommand {
    private IDName idName;
    private long point;
}
