package com.manu.s.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto
{
    private String orderId;
    private String productName;
    private int quantity;
    private double price;
}
