package com.manu.s.rabbitmq.service;

import com.manu.s.rabbitmq.dto.OrderDto;
import com.manu.s.rabbitmq.entity.Order;

public interface OrderService
{

    Order saveOrders(Order order);

}
