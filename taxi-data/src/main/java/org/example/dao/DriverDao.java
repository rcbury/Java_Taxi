package org.example.dao;


import org.example.entity.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverDao extends CrudRepository<Driver, Long> {
    List<Driver> findByStatusId(Long id);
}
