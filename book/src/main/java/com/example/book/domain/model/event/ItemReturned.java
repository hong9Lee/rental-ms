package com.example.book.domain.model.event;

import com.example.book.domain.model.vo.IDName;
import com.example.book.domain.model.vo.Item;
import lombok.Getter;

@Getter
public class ItemReturned extends ItemRented {

    public ItemReturned(IDName idName, Item item, long point) {
        super(idName, item, point);
    }
}
