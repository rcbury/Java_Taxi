package org.example.service;

import org.example.Exceptions.InvalidOrderOperationException;
import org.example.dto.DriverDto;
import org.example.dto.OrderDto;
import org.example.enums.DriverStatus;
import org.example.enums.OrderStatus;
import org.example.repository.interfaces.DriverRepository;
import org.example.repository.interfaces.OrderRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    DriverRepository driverRepository;
    static final Long rubPerMinute = 20l;

    static final Long rubPerRide = 50l;

    public OrderService(OrderRepository orderRepository, DriverRepository driverRepository){
        this.orderRepository = orderRepository;
        this.driverRepository = driverRepository;
    }

    public List<OrderDto> getAllOrders(){
        var orders = orderRepository.getAll();

        return orders;
    }

    public OrderDto createOrder(OrderDto orderDto){
        orderDto.setStatusId(OrderStatus.LOOKING_DRIVER.getIndex());

        var order = orderRepository.createOrder(orderDto);

        order.setStatusId(OrderStatus.LOOKING_DRIVER.getIndex());

        return order;
    }

    public OrderDto assignDriver(Long orderId, Long driverId) throws Exception, InvalidOrderOperationException {
        var existingOrder = orderRepository.getById(orderId);

        if (existingOrder.getStatusId() != OrderStatus.LOOKING_DRIVER.getIndex()){
            throw new InvalidOrderOperationException(
                    "can only assign driver to an order with waiting for driver status");
        }

        var existingDriver = driverRepository.getById(driverId);

        existingOrder.setDriverId(existingDriver.getId());
        existingOrder.setStatusId(OrderStatus.DRIVING_TO_CLIENT.getIndex());

        existingDriver.setStatusId(OrderStatus.DRIVING_TO_CLIENT.getIndex());

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        driverRepository.update(existingDriver);

        return updatedOrder;
    }

    public OrderDto driverArrived(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        if (existingOrder.getStatusId() != OrderStatus.DRIVING_TO_CLIENT.getIndex()){
            throw new InvalidOrderOperationException(
                    "can only use driver arrived with an order with driving to client status");
        }

        existingOrder.setStatusId(OrderStatus.ARRIVED_TO_CLIENT.getIndex());

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }

    public OrderDto startRide(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        if (existingOrder.getStatusId() != OrderStatus.ARRIVED_TO_CLIENT.getIndex()){
            throw new InvalidOrderOperationException(
                    "can only start ride with an order with waiting for client status");
        }

        var currentDate = new Date();

        existingOrder.setStatusId(OrderStatus.DRIVING_TO_DESTINATION.getIndex());
        existingOrder.setStartTime(currentDate);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        return updatedOrder;
    }

    public OrderDto endRide(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        if (existingOrder.getStatusId() != OrderStatus.DRIVING_TO_DESTINATION.getIndex()){
            throw new InvalidOrderOperationException(
                    "can only end ride with an order with driving to destination status");
        }

        existingOrder.setStatusId(OrderStatus.ARRIVED_TO_DESTINATION.getIndex());
        existingOrder.setEndTime(new Date());

        var rideMinutes = (existingOrder.getEndTime().getTime() - existingOrder.getStartTime().getTime()) / 1000 / 60;

        var price = rubPerRide + rideMinutes * rubPerMinute * existingOrder.getPriceMultiplier();

        existingOrder.setPrice(price);

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        var driver = driverRepository.getById(updatedOrder.getDriverId());

        FreeDriver(driver);

        return updatedOrder;
    }

    public OrderDto cancelRide(Long orderId) throws Exception {
        var existingOrder = orderRepository.getById(orderId);

        existingOrder.setStatusId(OrderStatus.CANCELLED.getIndex());

        var updatedOrder = orderRepository.updateOrder(existingOrder);

        var driver = driverRepository.getById(updatedOrder.getDriverId());

        FreeDriver(driver);

        return updatedOrder;
    }

    private void FreeDriver(DriverDto driver)
    {
        driver.setStatusId(DriverStatus.AVAILABLE.getIndex());
        driverRepository.update(driver);
    }
}
