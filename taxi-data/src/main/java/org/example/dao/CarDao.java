package org.example.dao;


import org.example.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarDao extends CrudRepository<Car, Long> {

}
