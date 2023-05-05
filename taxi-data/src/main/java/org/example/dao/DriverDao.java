package org.example.dao;


import org.example.entity.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverDao extends CrudRepository<Driver, Long> {

}
