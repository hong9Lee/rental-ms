package com.example.book.domain.model.event;

import com.example.book.domain.model.vo.IDName;
import com.example.book.domain.model.vo.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemRented {
    private IDName idName;
    private Item item;
    private long point;
}
