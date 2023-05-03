package org.example.repository;

import org.example.entity.Car;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private EntityManager entityManager;
    public CarRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Car> getAll() {
        var cars = this.entityManager.createQuery("""
                select c
                from cars c""")
                .getResultList();

        return cars;
    }

//    @Transactional
//    public Car addCar(CarDto carDto){
//        var car = CarMapper.INSTANCE.toEntity(carDto);
//        car = entityManager.merge(car);
//
//        var newCarDto = CarMapper.INSTANCE.toDto(car);
//
//        return newCarDto;
//    }
}
