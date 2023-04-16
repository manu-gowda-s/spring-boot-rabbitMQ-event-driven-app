package com.manu.s.stockservice.dto;

import com.manu.s.rabbitmq.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventsConsumeDto
{
    private String message;
    private String status;
    private Order order;
}
