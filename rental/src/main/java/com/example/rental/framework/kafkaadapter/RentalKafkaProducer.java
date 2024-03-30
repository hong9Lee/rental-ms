package com.example.rental.framework.kafkaadapter;

import com.example.rental.application.output_port.EventOutputPort;
import com.example.rental.domain.model.event.ItemRented;
import com.example.rental.domain.model.event.ItemReturned;
import com.example.rental.domain.model.event.OverdueCleared;
import com.example.rental.domain.model.event.PointUseCommand;
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
public class RentalKafkaProducer implements EventOutputPort {

    @Value(value = "@{producer.topic1.name}")
    private String TOPIC_RENT;

    @Value(value = "@{producer.topic2.name}")
    private String TOPIC_RETURN;

    @Value(value = "@{producer.topic3.name}")
    private String TOPIC_CLEAR;

    @Value(value = "${producers.topic4.name}")
    private String TOPIC_POINT;

    private final KafkaTemplate<String, ItemRented> kafkaTemplate1;
    private final KafkaTemplate<String, ItemReturned> kafkaTemplate2;
    private final KafkaTemplate<String, OverdueCleared> kafkaTemplate3;
    private final KafkaTemplate<String, PointUseCommand> kafkaTemplate4;

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

    @Override
    public void occurPointUserCommand(PointUseCommand pointUseCommand) {
        ListenableFuture<SendResult<String, PointUseCommand>> future =
                (ListenableFuture<SendResult<String, PointUseCommand>>) this.kafkaTemplate4.send(TOPIC_POINT, pointUseCommand);
        future.addCallback(new ListenableFutureCallback<SendResult<String,
                PointUseCommand>>() {
            private final Logger LOGGER =
                    LoggerFactory.getLogger(RentalKafkaProducer.class);

            @Override
            public void onSuccess(SendResult<String, PointUseCommand> result) {
                PointUseCommand g = result.getProducerRecord().value();
                LOGGER.info("Sent message=[" + g.getIdName().getId() + "] with offset =[" + result.getRecordMetadata().offset() + "] ");
            }

            @Override
            public void onFailure(Throwable t) {
                // needed to do compensation transaction.
                LOGGER.error("Unable to send message=[" +
                        pointUseCommand.getIdName().getId() + "] due to : " + t.getMessage(), t);
            }
        });
    }

}
