package com.manu.s.rabbitmq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_events_details")
public class Order
{
    @Id
    private String orderId;
    private String productName;
    private int quantity;
    private double price;

}
