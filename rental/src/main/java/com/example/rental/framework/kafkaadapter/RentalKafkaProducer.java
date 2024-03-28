package com.example.rental.framework.kafkaadapter;

import com.example.rental.application.output_port.EventOutputPort;
import com.example.rental.domain.model.event.ItemRented;
import com.example.rental.domain.model.event.ItemReturned;
import com.example.rental.domain.model.event.OverdueCleared;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalKafkaProducer implements EventOutputPort {

    @Value(value = "@{producer.topic1.name}")
    private String TOPIC_RENT;

    @Value(value = "@{producer.topic2.name}")
    private String TOPIC_RETURN;

    @Value(value = "@{producer.topic3.name}")
    private String TOPIC_CLEAR;

    private final KafkaTemplate<String, ItemRented> kafkaTemplate1;
    private final KafkaTemplate<String, ItemReturned> kafkaTemplate2;
    private final KafkaTemplate<String, OverdueCleared> kafkaTemplate3;

    @Override
    public void occurRentalEvent(ItemRented rentalItemEvent) throws JsonProcessingException {
        kafkaTemplate1.send(TOPIC_RENT, rentalItemEvent);
    }

    @Override
    public void occurReturnEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException {
        kafkaTemplate2.send(TOPIC_RETURN, itemReturnedEvent);
    }

    @Override
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException {
        kafkaTemplate3.send(TOPIC_CLEAR, overdueCleared);
    }
}
