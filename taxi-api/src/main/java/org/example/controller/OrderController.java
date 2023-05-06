package org.example.controller;

import org.example.dto.OrderDto;
import org.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        var createdOrderDto = orderService.createOrder(orderDto);

        return createdOrderDto;
    }

    @PostMapping
    @RequestMapping("/{orderId}/assignDriver")
    public OrderDto assignDriver(@PathVariable Long orderId, @RequestParam Long driverId) throws Exception {
        var orderDto = orderService.assignDriver(orderId, driverId);

        return orderDto;
    }

    @PostMapping
    @RequestMapping("/{orderId}/driverArrived")
    public OrderDto driverArrived(@PathVariable Long orderId) throws Exception {
        var orderDto = orderService.driverArrived(orderId);

        return orderDto;
    }

    @PostMapping
    @RequestMapping("/{orderId}/startRide")
    public OrderDto startRide(@PathVariable Long orderId) throws Exception {
        var orderDto = orderService.startRide(orderId);

        return orderDto;
    }

    @PostMapping
    @RequestMapping("/{orderId}/endRide")
    public OrderDto endRide(@PathVariable Long orderId) {
        return null;
    }

    @PostMapping
    @RequestMapping("/{orderId}/cancelRide")
    public OrderDto cancelRide(@PathVariable Long orderId) {
        return null;
    }
    @ExceptionHandler({Exception.class})
    public void handleException(){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error");
    }
}
