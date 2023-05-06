package org.example.repository.interfaces;

import org.example.dto.OrderDto;

import java.util.List;

public interface OrderRepository {
    OrderDto createOrder(OrderDto orderDto);
    List<OrderDto> getAll();
}
