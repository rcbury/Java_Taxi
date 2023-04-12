package org.example.service;

import org.example.dto.CarDto;
import org.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public CarDto addCar(CarDto carDto){
        var addedCar = carRepository.addCar(carDto);
        return addedCar;
    }

    public List<CarDto> getCars(){
        var carList = carRepository.getAll();
        return carList;
    }

}
