package org.example.service;

import org.example.dto.OrderDto;
import org.example.repository.interfaces.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrders(){
        var orders = orderRepository.getAll();

        return orders;
    }

    public OrderDto createOrder(OrderDto orderDto){
        var order = orderRepository.createOrder(orderDto);

        return order;
    }


}
