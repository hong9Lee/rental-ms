package com.example.member.domain.event;

import com.example.member.domain.model.vo.IDName;
import com.example.member.domain.model.vo.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemRented {
    private IDName idName;
    private Item item;
    private long point;
}
