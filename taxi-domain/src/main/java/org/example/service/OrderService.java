package org.example.service;

import org.example.dto.OrderDto;
import org.example.repository.interfaces.DriverRepository;
import org.example.repository.interfaces.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    DriverRepository driverRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrders(){
        var orders = orderRepository.getAll();

        return orders;
    }

    public OrderDto createOrder(OrderDto orderDto){
        var order = orderRepository.createOrder(orderDto);

        order.setStatusId(1l);

        return order;
    }

    public OrderDto assignDriver(Long orderId, Long driverId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        var existingDriver = driverRepository.getById(driverId);

        existingOrder.setDriverId(existingDriver.getId());
        existingOrder.setStatusId(2l);

        existingDriver.setStatusId(2l);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        driverRepository.update(existingDriver);

        return updatedOrder;
    }

    public OrderDto driverArrived(OrderDto newOrder) throws Exception {
        var existingOrder = orderRepository.getById(newOrder.getId());

        existingOrder.setStatusId(3l);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }

    public OrderDto startRide(OrderDto newOrder) throws Exception {
        var existingOrder = orderRepository.getById(newOrder.getId());

        existingOrder.setStatusId(3l);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }

    public OrderDto endRide(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        existingOrder.setStatusId(5l);
        existingOrder.setEndTime(new Date());

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }

    public OrderDto cancelRide(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        existingOrder.setStatusId(6l);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }
}
