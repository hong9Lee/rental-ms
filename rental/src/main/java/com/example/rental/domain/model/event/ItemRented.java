package com.example.rental.domain.model.event;

import com.example.rental.domain.model.vo.IDName;
import com.example.rental.domain.model.vo.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemRented {
    private IDName idName;
    private Item item;
    private long point;
}
