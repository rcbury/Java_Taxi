package org.example.dao;

import org.example.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderDao extends CrudRepository<Order, Long> {
    List<Order> findByStatusIdAndDriverIdAndEndTime(Long statusId, Long driverId, Date endTime);
    List<Order> findByStatusIdAndDriverIdAndEndTimeBetween(Long statusId, Long driverId, Date start, Date end);

}
