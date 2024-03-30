package com.example.book.framework.kafkaadapter;

import com.example.book.domain.model.event.EventResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class BookEventProducer {

    @Value(value = "${producers.topic1.name}")
    private String TOPIC;
    private final KafkaTemplate<String, EventResult> kafkaTemplate;

    public void occurEvent(EventResult result) throws JsonProcessingException {
        ListenableFuture<SendResult<String, EventResult>> future =
                (ListenableFuture<SendResult<String, EventResult>>) this.kafkaTemplate.send(TOPIC, result);
        future.addCallback(new ListenableFutureCallback<SendResult<String,
                EventResult>>() {
            @Override
            public void onSuccess(SendResult<String, EventResult> result) {
                EventResult g = result.getProducerRecord().value();
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }
}
