package com.dikara.kafka.consumer;

import com.dikara.kafka.dto.OrderCreatedEvent;
import com.dikara.kafka.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final PaymentService paymentService;

    public OrderConsumer(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @KafkaListener(
            topics = "order-created",
            groupId = "payment-group"
    )
    public void consume(OrderCreatedEvent event) {

        System.out.println("Received order event: " + event.getOrderId());
        paymentService.processPayment(event);

    }

}
