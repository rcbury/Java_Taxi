package org.example.controller;

import org.example.dto.CarDto;
import org.example.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;

    public CarController (CarService carService){
        this.carService = carService;
    }

    @PostMapping
    public CarDto addCar(@RequestBody CarDto carDto){
        var addedCarDto = carService.addCar(carDto);

        return addedCarDto;
    }

    @GetMapping
    public List<CarDto> getAll(){
        var carList = carService.getCars();
        return carList;
    }
}
