package org.example.service;

import org.example.dto.CarDto;
import org.example.dto.DriverDto;
import org.example.dto.UserDto;
import org.example.interfaces.CarRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    CarRepositoryInterface repository;

    CarService(CarRepositoryInterface repository) {
        this.repository = repository;
    }

    public CarDto create(CarDto carDto) {
        return repository.create(carDto);
    }
    public void delete(Long id) {
        repository.delete(id);
    }
    public CarDto getById(Long id) {
        return repository.getById(id);
    }
    public CarDto update(CarDto carDto) {
        return repository.update(carDto);
    }

    public List<CarDto> getAll() {
        return repository.getAll();
    }
}
