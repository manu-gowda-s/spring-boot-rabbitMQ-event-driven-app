package com.manu.s.stockservice.entity;

import com.manu.s.rabbitmq.entity.Order;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock_events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDetails
{
    @Id
    private String id;
    private String message;
    private String status;
    private Order order;
}
