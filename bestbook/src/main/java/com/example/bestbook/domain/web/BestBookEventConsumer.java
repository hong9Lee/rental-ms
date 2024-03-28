package com.example.bestbook.domain.web;

import com.example.bestbook.domain.model.event.ItemRented;
import com.example.bestbook.domain.service.BestBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BestBookEventConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BestBookService bestBookService;

    @KafkaListener(topics = "rental_rent", groupId = "bestbook")
    public void consume(ConsumerRecord<String, String> record) throws IOException {
        ItemRented itemRented = objectMapper.readValue(record.value(),
                ItemRented.class);
        bestBookService.dealBestBook(itemRented.getItem());
    }
}
