package com.dikara.kafka.producer;

import com.dikara.kafka.dto.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    private static final String Topic = "order-created";

    public void sendOrderCreatedEvent(OrderCreatedEvent event) {

        kafkaTemplate.send(Topic
                , event);

        System.out.println("Event sent to Kafka: " + event);
    }

}
