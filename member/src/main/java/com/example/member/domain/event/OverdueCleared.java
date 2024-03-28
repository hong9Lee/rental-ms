package com.example.member.domain.event;

import com.example.member.domain.model.vo.IDName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OverdueCleared {
    private IDName idName;
    private long point;
}
