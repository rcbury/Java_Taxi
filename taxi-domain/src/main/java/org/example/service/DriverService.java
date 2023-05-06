package org.example.service;

import org.example.dto.DriverDto;
import org.example.dto.OrderDto;
import org.example.enums.DriverStatus;
import org.example.enums.OrderStatus;
import org.example.repository.interfaces.DriverRepository;
import org.example.repository.interfaces.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Service
public class DriverService {
    DriverRepository driverRepository;
    OrderRepository orderRepository;

    DriverService(DriverRepository driverRepository, OrderRepository orderRepository) {
        this.driverRepository = driverRepository;
        this.orderRepository = orderRepository;
    }

    public DriverDto create(DriverDto driverDto) {
        return driverRepository.create(driverDto);
    }
    public void delete(Long id) {
        driverRepository.delete(id);
    }
    public DriverDto getById(Long id) {
        return driverRepository.getById(id);
    }
    public DriverDto update(DriverDto driverDto) {
        return driverRepository.update(driverDto);
    }

    public List<DriverDto> getAll() {
        return driverRepository.getAll();
    }

    public List<DriverDto> getFreeDrivers()
    {
        var freeDrivers = driverRepository.findByStatusId(DriverStatus.AVAILABLE);
        return freeDrivers;
    }

    public void sendOnLine(Long driverId)
    {
        var driver = driverRepository.getById(driverId);
        driver.setStatusId(DriverStatus.AVAILABLE.getIndex());
        driverRepository.update(driver);
    }

    public void sendOffLine(Long driverId)
    {
        var driver = driverRepository.getById(driverId);
        driver.setStatusId(DriverStatus.NOT_AVAILABLE.getIndex());
        driverRepository.update(driver);
    }

    public double getSalary(Long driverId, Date endDate)
    {
        var orders = orderRepository.getFinishedOrders(driverId, endDate);
        return getMoneyFromOrders(orders);
    }

    private double getMoneyFromOrders(List<OrderDto> orders)
    {
        double money = 0;
        for (var order : orders)
        {
            money += order.getPrice();
        }
        return money;
    }
}
