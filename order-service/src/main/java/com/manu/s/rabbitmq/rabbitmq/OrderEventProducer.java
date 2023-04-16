package com.manu.s.rabbitmq.rabbitmq;

import com.manu.s.rabbitmq.dto.OrderEventsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrderEvents(OrderEventsDto orderEventsDto)
    {
        LOGGER.info(String.format("Order event sent --->> %s", orderEventsDto.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,orderEventsDto);
    }
}
