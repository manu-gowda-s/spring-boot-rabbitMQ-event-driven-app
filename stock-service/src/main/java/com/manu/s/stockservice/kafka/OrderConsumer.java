package com.manu.s.stockservice.kafka;

import com.manu.s.rabbitmq.dto.OrderEventsDto;
import com.manu.s.stockservice.dto.OrderEventsConsumeDto;
import com.manu.s.stockservice.entity.StockDetails;
import com.manu.s.stockservice.repo.StockDetailsRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderConsumer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private StockDetailsRepository stockDetailsRepository;

    private ModelMapper modelMapper;

    public OrderConsumer(StockDetailsRepository stockDetailsRepository, ModelMapper modelMapper) {
        this.stockDetailsRepository = stockDetailsRepository;
        this.modelMapper=modelMapper;
    }

    @RabbitListener(
            queues = "${rabbitmq.queue.name}"
    )
    public void consumeOrderEvents(OrderEventsDto orderEventsDto)
    {
        LOGGER.info(String.format("Order event consumed -------> %s", orderEventsDto.toString()));

        // Save to database
        OrderEventsConsumeDto eventsConsumeDto = modelMapper.map(orderEventsDto, OrderEventsConsumeDto.class);

        StockDetails stockDetails = new StockDetails();

        stockDetails.setId(UUID.randomUUID().toString());
        stockDetails.setMessage(eventsConsumeDto.getMessage());
        stockDetails.setStatus(eventsConsumeDto.getStatus());
        stockDetails.setOrder(eventsConsumeDto.getOrder());

        stockDetailsRepository.save(stockDetails);
    }

}
