package com.dikara.kafka.repository;



import com.dikara.kafka.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
