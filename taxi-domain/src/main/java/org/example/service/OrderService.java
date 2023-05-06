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
    static final Long rubPerMinute = 2l;

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

        if (existingOrder.getStatusId() == 1L){

        }

        var existingDriver = driverRepository.getById(driverId);

        existingOrder.setDriverId(existingDriver.getId());
        existingOrder.setStatusId(2L);

        existingDriver.setStatusId(2L);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        driverRepository.update(existingDriver);

        return updatedOrder;
    }

    public OrderDto driverArrived(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        existingOrder.setStatusId(6L);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }

    public OrderDto startRide(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);
        var currentDate = new Date();

        existingOrder.setStatusId(3L);
        existingOrder.setStartTime(currentDate);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }

    public OrderDto endRide(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        existingOrder.setStatusId(5l);
        existingOrder.setEndTime(new Date());

        var rideMinutes = (existingOrder.getEndTime().getTime() - existingOrder.getStartTime().getTime()) / 1000 / 60;

        var price = rideMinutes * rubPerMinute;

        existingOrder.setPrice(price);

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
