package org.example.controller;

import org.example.dto.OrderDto;
import org.example.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> GetOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    public OrderDto CreateOrder(@RequestBody OrderDto orderDto) {
        var createdOrderDto = orderService.createOrder(orderDto);

        return createdOrderDto;
    }

    @PostMapping
    public OrderDto CreateOrder(@RequestBody OrderDto orderDto) {
        var createdOrderDto = orderService.createOrder(orderDto);

        return createdOrderDto;
    }
}
