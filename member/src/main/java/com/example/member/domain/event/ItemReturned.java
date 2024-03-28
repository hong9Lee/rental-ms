package com.example.member.domain.event;


import com.example.member.domain.model.vo.IDName;
import com.example.member.domain.model.vo.Item;
import lombok.Getter;

@Getter
public class ItemReturned extends ItemRented {

    public ItemReturned(IDName idName, Item item, long point) {
        super(idName, item, point);
    }
}
