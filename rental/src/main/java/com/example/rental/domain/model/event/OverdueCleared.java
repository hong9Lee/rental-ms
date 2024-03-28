package com.example.rental.domain.model.event;

import com.example.rental.domain.model.vo.IDName;
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
