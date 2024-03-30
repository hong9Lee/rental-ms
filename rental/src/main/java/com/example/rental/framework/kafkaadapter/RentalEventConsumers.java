package com.example.rental.framework.kafkaadapter;

import com.example.rental.application.use_case.CompensationUsecase;
import com.example.rental.domain.model.event.EventResult;
import com.example.rental.domain.model.event.EventType;
import com.example.rental.domain.model.vo.IDName;
import com.example.rental.domain.model.vo.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalEventConsumers {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final CompensationUsecase compensationUsecase;

    @KafkaListener(topics = "${consumer.topic1.name}", groupId = "${consumer.groupid.name}")
    public void consumeRental(ConsumerRecord<String, String> record) throws
            Exception {
        try {
            System.out.printf("ConsumerRecord: " + record.value());
            EventResult eventResult = objectMapper.readValue(record.value(),
                    EventResult.class);
            IDName idName = eventResult.getIdName();
            Item item = eventResult.getItem();
            long point = eventResult.getPoint();
            if (!eventResult.isSuccessed()) {
                EventType eventType = eventResult.getEventType();
                System.out.println("eventType =" + eventType.toString());
                switch (eventType) {
                    case RENT:
                        compensationUsecase.cancelRentItem(idName, item);
                        System.out.println("대여취소 보상트랜젝션 실행");
                        break;
                    case RETURN:
                        compensationUsecase.cancelReturnItem(idName, item, point);
                        break;
                    case OVERDUE:
                        compensationUsecase.cancelMakeAvailableRental(idName, point);
                        break;
                    default:
                    // 다른 이벤트 유형에 대한 처리를 여기에 추가
                }
                // 포인트 보상처리 (모든 경우에 공통)
            } else {
                System.out.println("eventResult.isSuccessed()" + eventResult.isSuccessed());
            }
        } catch (Exception e) {
            throw e; // 예외에 대한 처리 }
        }
    }
}
