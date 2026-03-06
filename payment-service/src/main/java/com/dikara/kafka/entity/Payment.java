package com.dikara.kafka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private Long orderId;

    @Column(name = "status")
    private String status;

}
