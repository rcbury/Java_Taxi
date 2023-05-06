package org.example.repository;

import org.example.dao.CarDao;
import org.example.dto.CarDto;
import org.example.mappers.CarMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements org.example.repository.interfaces.CarRepository {
    private CarDao carDao;
    private CarMapper mapper;

    public CarRepository(CarDao carDao, CarMapper mapper)
    {
        this.carDao = carDao;
        this.mapper = mapper;
    }

    public CarDto create(CarDto car)
    {
        var carEntity = mapper.toEntity(car);
        carDao.save(carEntity);
        return mapper.toDto(carEntity);
    }

    public CarDto update(CarDto car)
    {
        var optionalCar = carDao.findById(car.getId());
        if (optionalCar.isPresent())
        {
            var carEntity = mapper.toEntity(car);
            carDao.save(carEntity);
        }
        return car;
    }

    public CarDto getById(Long id)
    {
        var optionalEntity = carDao.findById(id);
        if (optionalEntity.isPresent())
        {
            return mapper.toDto(optionalEntity.get());
        }
        CarDto dto = new CarDto();
        return dto;
    }

    public List<CarDto> getAll()
    {
        var cars = carDao.findAll();
        var carList = new ArrayList<Car>();
        cars.forEach(carList::add);

        return mapper.toDtos(carList);
    }

    public void delete(Long id)
    {
        carDao.deleteById(id);
    }
}
