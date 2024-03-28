package com.example.bestbook.domain.model.event;

import com.example.bestbook.domain.model.IDName;
import com.example.bestbook.domain.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemRented {
    private IDName idName;
    private Item item;
    private long point;
}
