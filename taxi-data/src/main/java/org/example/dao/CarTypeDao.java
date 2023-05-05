package org.example.dao;


import org.example.entity.CarType;
import org.springframework.data.repository.CrudRepository;

public interface CarTypeDao extends CrudRepository<CarType, Long> {

}
