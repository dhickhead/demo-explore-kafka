package com.dikara.kafka.service;

import com.dikara.kafka.dto.OrderCreatedEvent;
import com.dikara.kafka.entity.Payment;
import com.dikara.kafka.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final  PaymentRepository paymentRepository;


    public void processPayment(OrderCreatedEvent event){

        Payment payment = new Payment();

        payment.setOrderId(event.getOrderId());
        //payment.setStatus("PENDING");
        payment.setStatus("SUCCESS");

        paymentRepository.save(payment);
        System.out.println("Payment processed");

    }

}
