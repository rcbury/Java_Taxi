package org.example.repository;

import org.example.entity.Car;
import org.example.dto.CarDto;
import org.example.mappers.CarMapper;
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

    public List<CarDto> getAll() {
        var cars = this.entityManager.createQuery("""
                select c
                from cars c""")
                .getResultList();

        var carDtoList = new ArrayList<CarDto>();

        for (var car : cars){
            Car castedCar = (Car)car;

            var carDto = CarMapper.INSTANCE.toDto(castedCar);
            carDtoList.add(carDto);
        }

        return carDtoList;
    }

    @Transactional
    public CarDto addCar(CarDto carDto){
        var car = CarMapper.INSTANCE.toEntity(carDto);
        car = entityManager.merge(car);

        var newCarDto = CarMapper.INSTANCE.toDto(car);

        return newCarDto;
    }
}
