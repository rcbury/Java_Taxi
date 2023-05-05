package org.example.repository;

import org.example.dao.OrderDao;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.entity.Car;
import org.example.entity.Order;
import org.example.mappers.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private OrderDao orderDao;
    private OrderMapper orderMapper;

    public OrderRepository(OrderDao orderDao, OrderMapper orderMapper) {
        this.orderDao = orderDao;
        this.orderMapper = orderMapper;
    }

    public OrderDto getById(Long id){
        var order = orderDao.findById(id);
        if (order.isPresent()){
            return orderMapper.toDto(order.get());
        }

        return new OrderDto();
    }

    public OrderDto create(OrderDto car)
    {
        Car carEntity = new Car();

        var orderEntity = orderMapper.toEntity(car);

        orderDao.save(orderEntity);
        //return mapper.toDto(carEntity);
    }
}
