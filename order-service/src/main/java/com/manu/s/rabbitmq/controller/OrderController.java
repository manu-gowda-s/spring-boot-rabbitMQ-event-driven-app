package com.manu.s.rabbitmq.controller;

import com.manu.s.rabbitmq.dto.OrderDto;
import com.manu.s.rabbitmq.dto.OrderEventsDto;
import com.manu.s.rabbitmq.entity.Order;
import com.manu.s.rabbitmq.rabbitmq.OrderEventProducer;
import com.manu.s.rabbitmq.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController
{
    private OrderService orderService;

    private OrderEventProducer orderEventProducer;

    public OrderController(OrderService orderService, OrderEventProducer orderEventProducer) {
        this.orderService = orderService;
        this.orderEventProducer = orderEventProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> savedOrders(@RequestBody Order order)
    {
        // generating random order Id
        order.setOrderId(UUID.randomUUID().toString());

        Order saveOrders = orderService.saveOrders(order);

        OrderEventsDto orderEventsDto = new OrderEventsDto();
        orderEventsDto.setStatus("PLACED");
        orderEventsDto.setMessage("Hurray your Order if confirmed !!");
        orderEventsDto.setOrder(saveOrders);

        orderEventProducer.sendOrderEvents(orderEventsDto);

        return new ResponseEntity<>("Order Event Sent successfully to exchange", HttpStatus.CREATED);
    }
}
