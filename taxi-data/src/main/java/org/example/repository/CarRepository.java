package org.example.repository;

import org.example.dao.CarDao;
import org.example.dto.CarDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private CarDao dao;

    public CarRepository(CarDao dao)
    {
        this.dao = dao;
    }

    public CarDto create(CarDto car)
    {
        return car;
    }

    public CarDto update(CarDto car)
    {
        return car;
    }

    public CarDto getById(Long id)
    {
        CarDto dto = new CarDto();
        return dto;
    }

    public List<CarDto> getAll(Long id)
    {
        List<CarDto> dtoList = new ArrayList<CarDto>();
        return dtoList;
    }

    public void delete(Long id)
    {
        
    }


}
