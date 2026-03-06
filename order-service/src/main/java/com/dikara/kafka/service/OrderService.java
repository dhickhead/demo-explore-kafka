package com.dikara.kafka.service;



import com.dikara.kafka.dto.OrderCreatedEvent;
import com.dikara.kafka.dto.OrderRequest;
import com.dikara.kafka.entity.Order;
import com.dikara.kafka.producer.OrderProducer;
import com.dikara.kafka.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository,OrderProducer orderProducer ) {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    public Order createOrder(OrderRequest request) {

        Order order = new Order();

        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());
        order.setStatus("PENDING");

        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getPrice(),
                savedOrder.getStatus()
        );



        orderProducer.sendOrderCreatedEvent(event);

        return savedOrder;
    }
}
