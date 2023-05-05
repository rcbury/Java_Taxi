package org.example.dao;


import org.example.entity.DriverStatus;
import org.springframework.data.repository.CrudRepository;

public interface DriverStatusDao extends CrudRepository<DriverStatus, Long> {

}
