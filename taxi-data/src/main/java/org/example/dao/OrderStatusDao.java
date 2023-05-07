package org.example.dao;

import org.example.entity.OrderStatus;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusDao extends CrudRepository<OrderStatus, Long> {
}
