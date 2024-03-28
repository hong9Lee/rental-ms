package com.example.bestbook.domain.repository;

import com.example.bestbook.domain.model.BestBook;
import com.example.bestbook.domain.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestBookRepository extends MongoRepository<BestBook, String> {
    BestBook findBestBookByItem(Item item);
}
