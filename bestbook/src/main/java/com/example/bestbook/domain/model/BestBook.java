package com.example.bestbook.domain.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestBook {

    @Id
    private String id;
    private Item item;
    private long rentCount;


    public static BestBook registerBestBook(Item item) {
        UUID uuid = UUID.randomUUID();
        BestBook bestBook = new BestBook();
        bestBook.setId(uuid.toString());
        bestBook.setItem(item);
        bestBook.setRentCount(1L);
        return bestBook;
    }

    public Long increaseBestBookCount() {
        this.rentCount = this.getRentCount() + 1;
        return this.rentCount;
    }
}
