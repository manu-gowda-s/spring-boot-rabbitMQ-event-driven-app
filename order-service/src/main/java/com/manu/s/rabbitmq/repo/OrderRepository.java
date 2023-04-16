package com.manu.s.rabbitmq.repo;

import com.manu.s.rabbitmq.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>
{

}
