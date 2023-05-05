package org.example.controller;

import org.example.dto.CarDto;
import org.example.dto.UserDto;
import org.example.service.CarService;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/{id}", method = GET)
    @GetMapping
    public CarDto getCar(@PathVariable("id") Long id) {
        var response = carService.getById(id);

        return response;
    }

    @PostMapping
    public CarDto add(@RequestBody CarDto car) {
        var response = carService.create(car);

        return response;
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @DeleteMapping
    public void deleteCar(@PathVariable("id") Long id) {
        carService.delete(id);
    }

    @PutMapping
    public CarDto putCar(@RequestBody CarDto car) {
        var response = carService.update(car);

        return response;
    }

    @RequestMapping(value = "/all", method = GET)
    @GetMapping
    public List<CarDto> getCars() {
        var response = carService.getAll();

        return response;
    }
}