package org.example.dao;

import org.example.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderDao extends CrudRepository<Order, Long> {
    List<Order> findByStatusIdAndDriverIdAndEndDate(Long statusId, Long driverId, Date endDate);
}
