package org.example.repository.interfaces;

import org.example.dto.OrderDto;

import java.util.Date;
import java.util.List;

public interface OrderRepository {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto) throws Exception;
    OrderDto getById(Long id) throws Exception;

    List<OrderDto> getAll();
    List<OrderDto> getFinishedOrders(Long driverId, Date endDate);
}
