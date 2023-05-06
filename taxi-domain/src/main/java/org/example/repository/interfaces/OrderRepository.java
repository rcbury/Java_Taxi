package org.example.repository.interfaces;

import org.example.dto.OrderDto;

import java.util.List;

public interface OrderRepository {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto);
    OrderDto getById(Long id) throws Exception;

    List<OrderDto> getAll();
}
