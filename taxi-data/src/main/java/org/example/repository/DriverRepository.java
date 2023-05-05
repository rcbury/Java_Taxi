package org.example.repository;

import org.example.dao.CarDao;
import org.example.dao.CarTypeDao;
import org.example.dao.DriverDao;
import org.example.dto.CarDto;
import org.example.entity.Car;
import org.example.mappers.CarMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private CarDao carDao;
    private DriverDao driverDao;
    private CarTypeDao carTypeDao;
    private CarMapper mapper;

    public CarRepository(CarDao carDao, DriverDao driverDao,
                         CarTypeDao carTypeDao, CarMapper mapper)
    {
        this.carDao = carDao;
        this.driverDao = driverDao;
        this.carTypeDao = carTypeDao;
        this.mapper = mapper;
    }

    public CarDto create(CarDto car)
    {
        Car carEntity = new Car();
        var driver = driverDao.findById(car.getDriverId());
        var carType = carTypeDao.findById(car.getTypeId());
        if (driver.isPresent())
        {
            carEntity.setCurrentDriver(driver.get());
        }
        if (carType.isPresent())
        {
            carEntity.setType(carType.get());
        }
        carEntity.setPlateNumber(car.getPlateNumber());
        carEntity.setDescription(car.getDescription());
        carDao.save(carEntity);
        return mapper.toDto(carEntity);
    }

    public CarDto update(CarDto car)
    {
        var optionalCar = carDao.findById(car.getId());
        if (optionalCar.isPresent())
        {
            var carEntity = optionalCar.get();
            var driver = driverDao.findById(car.getDriverId());
            var carType = carTypeDao.findById(car.getTypeId());
            if (driver.isPresent())
            {
                carEntity.setCurrentDriver(driver.get());
            }
            if (carType.isPresent())
            {
                carEntity.setType(carType.get());
            }
            carEntity.setPlateNumber(car.getPlateNumber());
            carEntity.setDescription(car.getDescription());
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
        var carList = carDao.findAll();
        var carDtoList = new ArrayList<CarDto>();
        for (var car : carList)
        {
            carDtoList.add(mapper.toDto(car));
        }
        return carDtoList;
    }

    public void delete(Long id)
    {
        carDao.deleteById(id);
    }


}
