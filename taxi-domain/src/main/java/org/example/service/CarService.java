package org.example.service;


import org.example.repository.ICarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private ICarRepository carRepository;

    public CarService(ICarRepository carRepository){
        this.carRepository = carRepository;
    }

//    public CarDto addCar(CarDto carDto){
//        var addedCar = carRepository.addCar(carDto);
//        return addedCar;
//    }

//    public List<CarDto> getCars(){
//        var carList = carRepository.getAll();
//        return carList;
//    }

}
