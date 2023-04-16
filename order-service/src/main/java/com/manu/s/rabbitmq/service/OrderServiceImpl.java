package com.manu.s.rabbitmq.service;

import com.manu.s.rabbitmq.dto.OrderDto;
import com.manu.s.rabbitmq.entity.Order;
import com.manu.s.rabbitmq.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService
{
    private OrderRepository orderRepository;

    private ModelMapper modelMapper;


    @Override
    public Order saveOrders(Order order)
    {
        //convert dto into jpa and save
       return orderRepository.save(order);
    }
}
