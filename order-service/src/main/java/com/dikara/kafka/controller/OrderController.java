package com.dikara.kafka.controller;

import com.dikara.kafka.dto.OrderRequest;
import com.dikara.kafka.entity.Order;
import com.dikara.kafka .service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }
}