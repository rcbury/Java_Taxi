package org.example.repository.interfaces;

import org.example.dto.CarDto;

import java.util.List;

public interface CarRepository {
    public CarDto create(CarDto carDto);
    public void delete(Long id);
    public CarDto getById(Long id);
    public List<CarDto> getAll();
    public CarDto update(CarDto carDto);
}
